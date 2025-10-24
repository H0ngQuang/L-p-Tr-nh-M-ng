/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;

import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class Lon_thu_K {
     public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN008", "HhPAxeDw");
        int k =a[a.length-1];
       
        int cnt =0;
        byte[] b =  Arrays.copyOf(a,a.length);
        Arrays.sort(a);
        int pos=0;
        for(int i=0;i<b.length;i++){
            if(b[i] ==a [a.length-k]){
                pos =i;
            }
        }
        sv.submitData("B21DCCN008", "HhPAxeDw",(a[a.length-k] + ", " +pos).getBytes());
     } 
}
