/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import RMI.*;
import java.rmi.registry.*;
/**
 *
 * @author Admin
 */
public class Dem_tan_so_ki_tu {
    public static void main(String[] args) throws Exception{
        Registry rg= LocateRegistry.getRegistry("203.162.10.109");
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = (String) sv.requestCharacter("B22DCCN604", "G4VeLsqW");
        
        String res ="";
        int []dem = new int[256];
        for(char c : s.toCharArray()){
            dem[c]++;
            
        }

        for(char c : s.toCharArray()){
            if(dem[c] > 0){
                res += String.format("\"%c\": %d, ", c,dem[c]);
                dem[c]=0;
            }
            
        }
        if (res.length() > 0) {
            res= res.substring(0,res.length()-2);
        }
        res = "{" + res + "}";

        sv.submitCharacter("B22DCCN604", "G4VeLsqW",res);
    }
}
