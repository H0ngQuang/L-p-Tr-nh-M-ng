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
        int n  =(int) sv.requestData("B22DCCN604", "9t8tUGvI");
        int []a = {1,2,5,10};
        List<Integer> lis = new ArrayList<>();
        while( n >0 ){
            if(n>=10){
                lis.add(10);
                n-=10;
                continue;
            }
            if(n>=5){
                lis.add(5);
                n-=5;
                continue;
            }
            if(n>=2){
                lis.add(2);
                n-=2;
                continue;
            }
            if(n>=1){
                lis.add(1);
                n-=1;
                continue;
            }
        }
        String res = lis.size() + "; ";
        for(int x : lis) res += x +",";
        res =res.substring(0,res.length()-1);
        sv.submitData("B22DCCN604", "9t8tUGvI",res);
    }
}
