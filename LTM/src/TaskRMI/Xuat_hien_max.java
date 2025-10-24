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
public class Xuat_hien_max {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN008", "HhPAxeDw");
        int []cnt = new int[256];
        for(byte x : a) cnt[x]++;
        int max= 0;
        byte val=a[0];
        for(byte x : a){
            if(cnt[x] > max){
                max =cnt[x];
                val = x;
            }
        }
        byte[] res ={val , (byte) max};
        sv.submitData("B21DCCN008", "HhPAxeDw",res);
    }
}
