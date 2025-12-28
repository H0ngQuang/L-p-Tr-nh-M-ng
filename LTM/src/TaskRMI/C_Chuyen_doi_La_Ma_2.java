/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;

import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author admin
 */
public class C_Chuyen_doi_La_Ma_2 {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN604", "aT3x7tVG");
        
        String res ="";
        int dec = Integer.valueOf(s);
        int[] tp = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] lm ={"M","CM" ,"D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i =0;i<tp.length;i++){
            while(dec >= tp[i]){
                res += lm[i];
                dec-=tp[i];
            }
        }
        sv.submitCharacter("B22DCCN604", "aT3x7tVG",res);
    }
    
}
