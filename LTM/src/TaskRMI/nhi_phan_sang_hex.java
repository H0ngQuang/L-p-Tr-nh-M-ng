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
public class nhi_phan_sang_hex {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte []a = sv.requestData("B22DCCN568", "POrw930v");
        String res ="";
        for(byte x : a) res += String.format("%02x", x & 0xFF);
        sv.submitData("B22DCCN568", "POrw930v" ,res.getBytes());
    }
}
