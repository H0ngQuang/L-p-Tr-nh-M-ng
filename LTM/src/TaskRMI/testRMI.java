/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;

import RMI.ByteService;
import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Admin
 */
public class testRMI {
    public static void main(String[] args) throws Exception{
         Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN759","g418wcAM");
        int []cnt = new int[256];
        for(char c : s.toCharArray()){
            cnt[c] ++;
        }
        String res ="";
        for(char c : s.toCharArray()){
            if(cnt[c] > 0){
                 res += String.format("\"%c\": %d, ", c,cnt[c]);
                cnt[c] =0;
            }
        }
        res = res.substring(0,res.length()-2);
        res ="{" + res + "}";
        sv.submitCharacter("B22DCCN759","g418wcAM", res);
     }
}
