/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskTCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Day_con_tang_dai_nhat {
    public static void main(String[] args) throws Exception{
    Socket socket = new Socket("203.162.10.109",2206);
    InputStream reader = socket.getInputStream();
    OutputStream writer = socket.getOutputStream();
    writer.write("B22DCCN568;HqFLCUMJ".getBytes());

    byte [] buffer = new byte[1024];
    int readLine = reader.read(buffer);
    String s = new String(buffer,0,readLine);
    String []line = s.trim().split(",");
    
    int n = line.length,a[] = new int[n];
    for (int i = 0; i < n; i++) a[i] = Integer.parseInt(line[i]);
    int f[]= new int[n],trace[] = new int[n],max=0,id=0;
    for (int i = 0; i < n; i++) {
    f[i] = 1;
    trace[i] = -1;
        }

    for(int i=0;i<n;i++){
        for(int j=0;j<i;j++){
            if(a[j] < a[i] && f[j] +1 > f[i]){
                f[i] = f[j]+1;
                trace[i]=j;            }
        } 
    }
    for(int i =0;i<n;i++){
        if(f[i] > max){
            max =f[i];
            id = i;
        }
    }   
    List<Integer> lis = new ArrayList<>();
    while (id != -1) {
        lis.add(a[id]); // thêm vào đầu để đảo đúng thứ tự
        id = trace[id];
    }
    String res="";
    for(int i = lis.size()-1;i>=0;i--){
       res +=lis.get(i)+",";
    }
   
    res = res.substring(0,res.length()-1);
    res += ";" +max ;
    writer.write(res.getBytes());
    writer.flush();
    }
    
}
