/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task2;

import UDP.Book;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Admin
 */
public class nXVf0t0O {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;

        // a. Gửi mã sinh viên + qCode
        String code = ";B22DCCN652;nXVf0t0O";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        // b. Nhận dữ liệu từ server
        byte[] buffer = new byte[10240];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        String requestId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + requestId);

        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Book book = (Book) ois.readObject();

        System.out.println("Before: " + book);

        // c. Chuẩn hóa dữ liệu

        // Title: viết hoa chữ cái đầu của mỗi từ, các ký tự còn lại in thường
        String[] wordsTitle = book.getTitle().trim().split("\\s+");
        StringBuilder fixedTitle = new StringBuilder();
        for (String w : wordsTitle) {
            fixedTitle.append(Character.toUpperCase(w.charAt(0)))
                      .append(w.substring(1).toLowerCase())
                      .append(" ");
        }
        book.setTitle(fixedTitle.toString().trim());

        // Author: lấy từ đầu (họ) + từ cuối (tên)
        String[] wordsAuthor = book.getAuthor().trim().split("\\s+");
        if (wordsAuthor.length >= 2) {
            String author = capitalize(wordsAuthor[0]) + ", " + capitalize(wordsAuthor[wordsAuthor.length - 1]);
            book.setAuthor(author);
        }

        // ISBN: format thành nhóm có dấu gạch ngang
        String isbn = book.getIsbn().trim();
        if (isbn.length() == 13) { // ISBN-13
            String isbnFormat = isbn.substring(0, 3) + "-" 
                              + isbn.substring(3, 4) + "-" 
                              + isbn.substring(4, 6) + "-" 
                              + isbn.substring(6, 12) + "-" 
                              + isbn.substring(12);
            book.setIsbn(isbnFormat);
        }

        // Publish date: yyyy-mm-dd -> mm/yyyy
        String[] dateParts = book.getPublishDate().trim().split("-");
        if (dateParts.length >= 2) {
            String publishDate = dateParts[1] + "/" + dateParts[0];
            book.setPublishDate(publishDate);
        }

        System.out.println("After: " + book);

        // d. Gửi lại đối tượng đã chuẩn hóa
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(book);
        oos.flush();

        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(requestId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());

        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);

        socket.close();
    }

    private static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
}
