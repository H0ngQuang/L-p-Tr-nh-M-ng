/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import java.rmi.registry.*;
import RMI.DataService;
import java.util.ArrayList;
/**
 *
 * @author admin
 */
public class D_Sinh_to_hop {
    static int n,k;
    static int [] a ;
    static ArrayList<Integer> b = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    static void Try( int st){
        for(int j = st;j <n;j++){
            b.add(a[j]);
            if(b.size() == k ){
                res.add(new ArrayList<>(b));
            }
            else Try( j+1);
           b.remove(b.size() - 1);

        }
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String)sv.requestData("B21DCCN053", "juC3u7C6");
        //String s = "2, 0, 5, 8, 1 ;3"; 
        
        String[] line = s.trim().split(";");
        line[0]= line[0].replace(",", " ");
        String [] ss =line[0].trim().split(" ");
        k = Integer.parseInt(line[1]);
        n = ss.length;
        a = new int[n];
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(ss[i]);
        Try(0);
        sv.submitData("B21DCCN053", "juC3u7C6",res);
        
    }
}
