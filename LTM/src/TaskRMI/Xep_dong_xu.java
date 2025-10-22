/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import RMI.DataService;
import java.rmi.registry.*;
import java.util.*;
/**
 *
 * @author Admin
 */
public class Xep_dong_xu {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        DataService sv = (DataService) rg.lookup("RMIDataService");
        Integer num =(Integer) sv.requestData("B22DCCN652", "sZrYmsHa");
        int [] a = {1,2,5,10};
        List<Integer> b = new ArrayList<>();
        String res ="";
        int cnt = 0;
        while(num > 0){
            if(num >= 10){
                cnt ++; 
                num-=10;
                b.add(10);
                continue;
                
            }
            if(num >=5 ){
                cnt ++; 
                num-=5;
                b.add(5);
                continue;
            }if(num >=2){
                cnt ++; 
                num-=2;
                b.add(2);
                continue;
            }if(num>=1) {
                b.add(1);
                cnt +=1;
                num -=1;
                continue;
        }}
        res = cnt+"; ";
        for(Integer i : b){
            res +=i + ",";
        }
        sv.submitData("B22DCCN652", "sZrYmsHa", res.substring(0, res.length()-1));
    }
}
