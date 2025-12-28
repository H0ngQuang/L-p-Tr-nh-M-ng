/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskWS;

import WS_D.*;
import java.util.*;

/**
 *
 * @author admin
 */
public class D_Sap_xep_CL {
    public static void main(String[] args) throws Exception{
        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();
        List<Integer>  a = port.getData("B22DCCN604", "vDn9z1uC");
        List<Integer>c = new ArrayList<>();
        List<Integer>  l= new ArrayList<>();
        List<Integer>  res= new ArrayList<>();
        for (int i : a){
            if(i%2==0) c.add(i);
            else l.add(i);
        }
        for(int i =0;i<Math.max(l.size(), c.size());i++){
            res.add(chan);
            res
        }        
    }
}
