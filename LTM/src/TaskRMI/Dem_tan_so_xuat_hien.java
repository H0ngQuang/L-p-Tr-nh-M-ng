/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import java.rmi.registry.*;
import RMI.CharacterService;
/**
 *
 * @author Admin
 */
public class Dem_tan_so_xuat_hien  {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = (String) sv.requestCharacter("B22DCCN652", "kWWGdJ9G");
        int [] dem = new int[256];
        for(char c : s.toCharArray()){
            dem[c]++;
        }
        String res = "";
        for(char c : s.toCharArray()){
            if(dem[c] > 0){
                res = res + String.valueOf(c) + dem[c];
                dem[c]=0;
            }
        }
        sv.submitCharacter("B22DCCN652", "kWWGdJ9G", res);
    }
}
