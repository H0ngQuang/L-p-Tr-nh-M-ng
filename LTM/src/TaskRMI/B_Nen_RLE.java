/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;

import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author admin
 */
public class B_Nen_RLE {
      public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN036", "2uG0lQGi");
        
        int n = a.length;
        int cnt =1;
        String res = "";
        for(int i =1;i<n;i++){
            if(a[i] == a[i-1]) cnt +=1;
            else {
                res += (char) a[i-1];
                res += (char) cnt;
                cnt =1;
            }
        }
        res += (char) a[n-1];
        res += (char) cnt ;
        sv.submitData("B21DCCN036", "2uG0lQGi",res.getBytes());  
    }

}
