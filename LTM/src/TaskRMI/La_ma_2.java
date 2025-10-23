/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class La_ma_2 {
    public static void main(String[] args)throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN032", "ADu6zRYE");
        System.out.println(s);
        
        String rm = "";
        int dec = Integer.parseInt(s);
        int[] tp ={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] lm ={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i =0;i<tp.length;i++){
            while(dec >= tp[i]){
                rm+= lm[i];
                dec-=tp[i];
            }
        }
        sv.submitCharacter("B21DCCN032", "ADu6zRYE", rm);
        
    }
}
