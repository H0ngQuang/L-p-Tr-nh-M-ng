/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
/**
 *
 * @author Admin
 */
public class Pytago {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int n = (int) sv.requestData("B21DCCN319", "NMATI6Zw");
        List<List<Integer>> res = new ArrayList<>();
        for(int i =1;i<n;i++){
            for(int j =i+1;j<n;j++){
                for(int k = j+1;k<n;k++){
                    if( i * i + j*j == k*k){
                        List<Integer> tri = new ArrayList<>();
                        tri.add(i);
                        tri.add(j);
                        tri.add(k);
                        res.add(tri);
                    }
                }
            }   
        
        }
        sv.submitData("B21DCCN319", "NMATI6Zw", res);
    }
}
