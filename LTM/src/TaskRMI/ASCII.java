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
public class ASCII {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109",1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte []a = sv.requestData("B22DCCN652", "mRhWu3NR");
        int doDich = a.length;
        for(int i =0;i<a.length;i++) a[i] +=doDich;
        sv.submitData("B22DCCN652", "mRhWu3NR", a);
     }
}
