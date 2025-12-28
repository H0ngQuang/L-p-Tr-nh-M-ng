/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import RMI.ByteService;
import java.rmi.registry.*;
/**
 *
 * @author admin
 */
public class B_Ma_hoa_caesar {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte [] a = sv.requestData("B22DCCN711", "TAyjVfR2");
        int n = a.length;
        byte []res = new byte[n];
        int cnt =0;
        for (byte x : a){
            res[cnt++] = (byte) (x +n );
        }
        sv.submitData("B22DCCN711", "TAyjVfR2",res);
    }
}
