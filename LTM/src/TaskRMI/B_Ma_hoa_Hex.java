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
public class B_Ma_hoa_Hex {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte [] a = sv.requestData("B22DCCN711", "TAyjVfR2");
        
        String res ="";
        for (byte x : a){
            res += String.format("%02x",x & 0xFF );
        }
        sv.submitData("B22DCCN711", "TAyjVfR2",res.toString().getBytes());
    }
}
