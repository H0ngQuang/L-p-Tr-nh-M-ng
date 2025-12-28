/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;
/**
 *
 * @author admin
 */
public class TestRMI_D {
     public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN016", "uZMEY3Zg");
        s = s.re
        String [] tmp = s.trim().split(" ");
        double tong =0;
        ArrayList<Double> a= new ArrayList<>();
        for(String w : tmp){
            a.add(Double.valueOf(w));
        }
        for(double x : a){
            tong +=x;
        }
        int n = a.size();
        double tbc = tong/n;
        double psai =0 ;
        for(double x : a){
            psai += (x-tbc) *(x-tbc);
        }
        psai /=n;
        String res = String.format("%.2d : %.2d",psai, Math.sqrt(psai));
        sv.submitData("B21DCCN016", "uZMEY3Zg",res);
    }
     
}
