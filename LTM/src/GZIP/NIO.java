/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GZIP;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*
         ;

/**
 *
 * @author admin
 */
public class NIO {
    public static void main(String[] args) throws Exception {
        SocketChannel socket = SocketChannel.open(new InetSocketAddress(hostname, 0));
        ByteBuffer send = ByteBuffer.wrap("B22DCCN652;123213".getBytes());
        socket.write(send);
        
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        socket.read(buffer);
        buffer.flip();
        
        String s = new String(buffer.array(),0,buffer.limit());
        String res= "";
        
        ByteBuffer send2 = ByteBuffer.wrap(res.getBytes());
        socket.write(send2);
        
    
    }
}
