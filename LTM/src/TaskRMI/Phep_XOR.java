/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import RMI.ByteService;
import java.rmi.registry.*;


public class Phep_XOR {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte [] a = sv.requestData("B22DCCN652", "yIXp8g6l");
        String key = "PTIT";
        byte [] keybyte = key.getBytes();
        byte[] res = new byte[a.length];
        
        for(int i =0;i<a.length;i++){
            res[i] = (byte) (a[i] ^ keybyte[i%4]);
        }
        sv.submitData("B22DCCN652", "yIXp8g6l",res);
    }
}
