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
public class C_Ma_hoa_CAESAR {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN604", "aT3x7tVG");
        
        String ans ="";
        int dich = s.length()%7;
        for (char c : s.toCharArray()){
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            c = (char) ((c - base - dich +26) %26 +base);
            ans+=c;
        }
        sv.submitCharacter("B22DCCN604", "aT3x7tVG", ans);

    }
}
