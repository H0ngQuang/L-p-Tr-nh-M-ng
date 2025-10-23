/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;

import RMI.*;
import java.rmi.registry.*;

import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;

/**
 *
 * @author admin
 */
public class Giai_ma_base_64 {
     public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte []a = sv.requestData("B22DCCN249", "l7oEcL04");
        String s= new String(a);
        byte[] ans = Base64.getDecoder().decode(s);
        sv.submitData(("B22DCCN249", "l7oEcL04", ans);


    }
}
