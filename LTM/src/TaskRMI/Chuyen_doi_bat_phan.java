/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import RMI.*;
import java.rmi.registry.*;
/**
 *
 * @author admin
 */
public class Chuyen_doi_bat_phan {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN008", "HhPAxeDw"); 
            String res = "";
        for(byte x : a){
            res += String.format("%03o",x & 0xFF);
        }
        sv.submitData("B21DCCN008", "HhPAxeDw",res.getBytes());
    }
}
