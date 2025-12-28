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
public class C_Len_max_min {
    public static int gcd (int a , int b){
        if(a ==0 ) return b;
        return gcd (b%a,a);
    }
    public static void main(String[] args) throws Exception{
        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();
        double x = port.getDataDouble("B21DCCN053", "juC3u7C6");
        x = Math.round(x*100) / 100.0;
        int tu = (int) (x *100.0);
        int mau = 100;
        int gcd = gcd(tu, mau);
        tu/=gcd;
        mau/=gcd;
        List<Integer> res = new ArrayList<>();
        res.add(tu);
        res.add(mau);
        port.submitDataIntArray("B21DCCN053", "juC3u7C6", res);
    }
}
