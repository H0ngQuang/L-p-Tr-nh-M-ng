/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskWS;

import WS.DataService;
import WS.DataService_Service;
import java.util.*;

/**
 *
 * @author admin
 */
public class D_TP_sang_NP {
    public static void main(String[] args) throws Exception{
        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();
        
        List<Integer>  a  = port.getData("B22DCCN604","nIy8CrP7");
        List<String> res = new ArrayList<>();
        for(int i : a) {
            res.add(Integer.toBinaryString(i));
        }
        port.submitDataStringArray("B22DCCN604","nIy8CrP7",res);
    }
}
 
