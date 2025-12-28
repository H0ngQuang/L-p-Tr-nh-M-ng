/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import java.rmi.registry.*;
import RMI.ObjectService;
import RMI.ProductX;
import java.io.Serializable;
/**
 *
 * @author admin
 */
public class O_ProductX {
    public static int format(String s ){
        int res  =0;
        for(char c : s.toCharArray()){
            if (Character.isDigit(c)) {
                res += c - '0';
            }
        }
        return res;
        
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        
        ProductX pro = (ProductX) sv.requestObject("B22DCCN604", "4cCaVV1K");
     
        pro.setDiscount(format(pro.getDiscountCode()));
        
        sv.submitObject("B22DCCN604", "4cCaVV1K",(Serializable) pro);
    }
}
