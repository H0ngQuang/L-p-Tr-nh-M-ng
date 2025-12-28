/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;

import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
/**
 *
 * @author admin
 */
public class B_Giai_ma_Base64 {
     public static void main(String[] args)throws Exception{
        String studentCode = "B21DCCN008";
        String qCode = "HhPAxeDw";  
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte [] a = sv.requestData(studentCode, qCode);
        
        // Giai ma
        String s = new String(a);
        byte []res= Base64.getDecoder().decode(s);
        sv.submitData(studentCode, qCode, res);
    }
}
