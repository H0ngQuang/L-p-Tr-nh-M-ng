/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GZIP;
import java.util.*;
import java.net.*;
import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/**
 *
 * @author admin
 */
public class GZIP_test {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2208);

        GZIPOutputStream gzipOut = new GZIPOutputStream(socket.getOutputStream());
        GZIPInputStream gzipIn = new GZIPInputStream(socket.getInputStream());
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(gzipIn));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(gzipOut));
        
        
        
    }
}
