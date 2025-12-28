/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import java.rmi.registry.*;
import RMI.DataService;
import java.util.*;
/**
 *
 * @author admin
 */
public class To_hop_ke_tiep {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        DataService sv = (DataService) rg.lookup("RMIDataService");
        Object obj =  sv.requestData("B22DCCN652", "GoMkI2pf");
        String s = obj.toString();
        ArrayList<Integer> a = new ArrayList<>();
        String []ss = s.trim().split(", ");
        for(String i : ss ){
            a.add(Integer.valueOf(i.trim()));
        }
        int n = a.size();
        int i = n-2;
        while(i>=0 && a.get(i) >= a.get(i+1)) {
            i--;
        }
        if (i<0){
            Collections.sort(a);
        }
        else {
            int j = n-1;
            while(a.get(i) >= a.get(j)) j--;
            Collections.swap(a, i, j);
            int l = i +1 , r =n-1;
            while( l < r ){
                Collections.swap(a,l,r);
                l ++;
                r--;
            }
        }
        String res = "";
        for(int x : a){
            res += x + ",";
        }
        res = res.substring(0,res.length()-1);
        sv.submitData("B22DCCN652", "GoMkI2pf", res);
        
    }
}
