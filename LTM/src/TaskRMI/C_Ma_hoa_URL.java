/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;

import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.net.URLEncoder;
/**
 *
 * @author admin
 */
public class C_Ma_hoa_URL {
     public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN604", "aT3x7tVG");
        String ans =URLEncoder.encode(s, "UTF-8");
        
        sv.submitCharacter("B21DCCN053", "KkihaRAB", ans);
     }
}
