/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskWS;
import java.util.*;
import WS_D.*;
/**
 *
 * @author admin
 */
public class D_Chuyen_doi_co_so {
    public static void main(String[] args) throws Exception{
        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();
        
        List<Integer> a = port.getData("B22DCCN759", "XRAFQIvW");
        List<String> res=  new ArrayList<>();
        for(int i : a){
            res.add(  Integer.toOctalString(i).toUpperCase()+"|" + Integer.toHexString(i).toUpperCase() );
        }
        port.submitDataStringArray("B22DCCN759", "XRAFQIvW",res);
    }
}
