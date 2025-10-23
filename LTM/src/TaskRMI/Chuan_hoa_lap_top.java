/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import RMI.*;
import RMI.Product;
import java.rmi.registry.*;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Admin
 */
public class Chuan_hoa_lap_top {
    public static String format1(String s){
        return s.toUpperCase();
    }
    public static Double format2(Double x){
        return x + 0.2 * x;
    }
    public static void main(String[] args) throws  Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Product pro = (Product) sv.requestObject("B22DCCN471", "QRiLA6RT");
        pro.setCode(format1(pro.getCode()));
        pro.setExportPrice(format2(pro.getImportPrice()));
        
        sv.submitObject("B22DCCN471", "QRiLA6RT",pro);
    }
}
