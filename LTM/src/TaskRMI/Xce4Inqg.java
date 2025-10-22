/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import RMI.DataService;
import java.rmi.registry.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Xce4Inqg {
    public static ArrayList<Integer>  a = new ArrayList<>();
    public static List<List<Integer>> res = new ArrayList<>();
    public static int n, k;
    public static int []b = new int[1005];
    public static void solve(){
        List<Integer> tmp = new ArrayList<>();
        for(int i =1;i<=k;i++){
            tmp.add(b[i]);
            
        }
        res.add(tmp);
        
    }
    public static void Try(int i ,int st){
        for(int j =st;j<n;j++){
            b[i] = a.get(j);
            if(i == k) solve();
            else Try(i+1,j+1);
            
        }
        
    }
    public static void main(String[] args) throws  Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109",1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B22DCCN652", "Xce4Inqg");
        //String s = "2, 0, 5, 8, 1 ;3"; 
        String[] line = s.trim().split(";");
        String[] s1 = line[0].trim().split(",");
        k = Integer.parseInt(line[1].trim());
      
        for(String w : s1){
            a.add(Integer.parseInt(w.trim()));
        }
    
        n= a.size();
        Try(1, 0);
        sv.submitData("B22DCCN652", "Xce4Inqg", res);

    }
}
