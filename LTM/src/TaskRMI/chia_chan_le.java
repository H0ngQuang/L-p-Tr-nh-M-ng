/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import RMI.ByteService;
import java.rmi.registry.*;
/**
 *
 * @author Admin
 */
public class chia_chan_le {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte [] a = sv.requestData("B22DCCN711","NkLDSGRX");
        byte [] res = new byte[a.length];
        int cnt =0;
        for(byte x : a){
            if(x % 2 ==0) res[cnt++] = x;
          
        }
         for(byte x : a){
            if(x % 2 !=0) res[cnt++] = x;
            
        }
        
        sv.submitData("B22DCCN711","NkLDSGRX", res);
    }
}
