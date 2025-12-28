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
public class TestRMI_B {
    public static void main(String[] args)throws Exception{
        String studentCode = "B21DCCN008";
        String qCode = "HhPAxeDw";  
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte [] a = sv.requestData(studentCode, qCode);
        
        // Giai ma
        
    }
}
