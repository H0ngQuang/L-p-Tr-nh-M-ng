/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import RMI.*;
import java.rmi.registry.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PhuongSai  {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s =(String) sv.requestData("B21DCCN016", "uZMEY3Zg");

        String[] tmp = s.trim().split(",");
        ArrayList<Double> a = new ArrayList<>();
        for(String i : tmp){
            a.add(Double.valueOf(i));
        }int n = a.size();
        double sum =0;
        for(double i : a){
            sum+=i;
        }
        double tbc = sum/=n;
        double sumpsai= 0;
        for(double i  : a){
            sumpsai += (tbc - i) * (tbc-i);
            
        }
        double psai = sumpsai/= n;
        double dlc = Math.sqrt(psai);
        
        String res = String.format("%.2f : %.2f", psai, dlc);
        sv.submitData("B21DCCN016", "uZMEY3Zg",res);
        
    }
    
}
