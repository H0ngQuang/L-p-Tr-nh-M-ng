/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;

/**
 *
 * @author admin
 */
public class B_lon_thu_K {
    
}
package RMI.B21DCCN066;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.ByteService;

public class LonThuK {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN066", "uIKHCTWG");
        for(byte x: a) System.out.print(x + " ");  
        System.out.println();
        //b.
        byte []b = Arrays.copyOf(a, a.length);
        int k = a[a.length - 1], pos = 0;
        Arrays.sort(a);
        for(int i = 0;i<b.length;i++){
            if(b[i]==a[a.length - k]){
                pos = i;
                break;
            }
        }
        byte []ans = {(byte)a[a.length - k], (byte)(pos + 1)};
        for(byte x: ans) System.out.print(x + " ");
        //c.
        sv.submitData("B21DCCN066", "uIKHCTWG", ans);
    }
}