/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import java.rmi.registry.*;
import RMI.CharacterService;
/**
 *
 * @author admin
 */
public class C_dem_so_lan_xuat_hien {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN604", "aT3x7tVG");
        int []cnt = new int[256];
        for(char c : s.toCharArray()){
            cnt[c] ++;
        }
        String res = "";
        for(char c : s.toCharArray()){
            if(cnt[c] >0) {
                res += String.format("\"%c\": %d, " ,c, cnt[c]);
                cnt[c]=0;
            }
        }
        res =res.substring(0,res.length()-2);
        res ="{" + res + "}";
        
        sv.submitCharacter("B22DCCN604", "aT3x7tVG",res);
        
    }
}
