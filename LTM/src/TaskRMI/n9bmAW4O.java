/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import RMI.ByteService;
import java.rmi.registry.*;
import java.util.Base64;


/**
 *
 * @author Admin
 */
public class n9bmAW4O  {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109",1099);
        ByteService sv = (ByteService) rg.lookup(("RMIByteService"));
        byte [] a= sv.requestData("B22DCCN652", "n9bmAW4O");
        String s = new String(a);
        byte [] ans = Base64.getDecoder().decode(s);
        sv.submitData("B22DCCN652","n9bmAW4O" , ans);
    
        
        
    }
    
    
}
