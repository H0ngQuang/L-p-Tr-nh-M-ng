/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import java.rmi.registry.*;
import RMI.ObjectService;
import RMI.Product;

/**
 *
 * @author admin
 */
public class O_Product {
    public static String format1(String s){
        return s.toUpperCase();
    }
    public static double format2(double x){
        return x +(double) x*20/100;
    }
    public static void main(String[] args)throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        
        Product pro =(Product) sv.requestObject("B22DCCN711","M84Pa21k");
        pro.setCode(format1(pro.getCode()));
        pro.setExportPrice(format2(pro.getImportPrice()));
        
        sv.submitObject("B22DCCN711","M84Pa21k",pro);
    }
}
