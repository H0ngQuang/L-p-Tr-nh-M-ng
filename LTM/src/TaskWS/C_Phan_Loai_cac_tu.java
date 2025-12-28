/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskWS;
import WS_C.*;
import java.util.*;
/**
 *
 * @author admin
 */
public class C_Phan_Loai_cac_tu {
    public static int count(String w){
        int cnt =0;
        for(char c : w.toCharArray()) {
            if(c=='u' ||c=='e' ||c=='a' ||c=='o' ||c=='i'  ){
                cnt ++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws  Exception{
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        
        List<String> a = port.requestStringArray("B22DCCN604", "vDn9z1uC");
        
        Map<Integer,List<String>> map = new HashMap<>();
        for (String w : a){
            int k = count(w);
            if(!map.containsKey(k)){
                map.put(k,new ArrayList<>());
            }
            map.get(k).add(w);
        }
                
        List<String> res = new ArrayList<>();
        for(int k : map.keySet()){
            List<String> tmp = map.get(k);
            Collections.sort(tmp);
            res.add(String.join(", ", tmp));
        }
        port.submitCharacterStringArray("B22DCCN604", "vDn9z1uC",res);
    }
}
