/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import RMI.ObjectService;
import RMI.*;

import java.rmi.registry.*;
/**
 *
 * @author Admin
 */
public class Xu_ly_don_hang {
    public static String solve(String s1,String s2, String s3){
        String res = s1.substring(0,2).toUpperCase() + s2.substring(s2.length()-3,s2.length());
        String []tmp= s3.trim().split("-");
        
        
        return res + tmp[2]+tmp[1];
    }
    
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Order order = (Order) sv.requestObject("B22DCCN652", "BpXvP8LY");
        
        order.setOrderCode(solve(order.getShippingType(),order.getCustomerCode(), order.getOrderDate()));
        sv.submitObject("B22DCCN652", "BpXvP8LY", order);
    }
}
