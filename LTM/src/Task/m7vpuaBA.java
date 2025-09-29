
package Task;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class m7vpuaBA {

    public void execute() {
        final String SERVER_HOST = "203.162.10.109"; // Đổi sang IP server thật
        final int SERVER_PORT = 2207;

        String studentCode = "B22DCCN759";
        String qCode = "m7vpuaBA";

        DatagramSocket socket = null;

        try {
            // 1. Tạo socket UDP
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName(SERVER_HOST);
            System.out.println(serverAddress);
            // 2. Gửi thông điệp ";studentCode;qCode"
            String message = ";" + studentCode + ";" + qCode;
            byte[] sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);
            socket.send(sendPacket);
            System.out.println("[SEND] " + message);

            // 3. Nhận phản hồi từ server
            byte[] buffer = new byte[4096];
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(receivePacket);
            String response = new String(receivePacket.getData(), 0, receivePacket.getLength()).trim();
            System.out.println("[RECV] " + response);

            // 4. Parse dữ liệu: "requestId;a1,a2,...,a50"
            String[] parts = response.split(";");
            String requestId = parts[0];
            String[] numberStrings = parts[1].split(",");

            int[] numbers = new int[numberStrings.length];
            for (int i = 0; i < numberStrings.length; i++) {
                numbers[i] = Integer.parseInt(numberStrings[i].trim());
            }

            int max = numbers[0];
            int min = numbers[0];
            for (int n : numbers) {
                if (n > max) {
                    max = n;
                }
                if (n < min) {
                    min = n;
                }
            }

            // 5. Gửi lại "requestId;max,min"
            String reply = requestId + ";" + max + "," + min;
            byte[] replyData = reply.getBytes();
            DatagramPacket replyPacket = new DatagramPacket(replyData, replyData.length, serverAddress, SERVER_PORT);
            socket.send(replyPacket);
            System.out.println("[SEND] " + reply);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
                System.out.println("Socket closed.");
            }
        }

    }

}
