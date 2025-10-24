/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import RMI.CharacterService;
import java.net.URLEncoder;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author Admin
 */
public class Ma_hoa_URL {
    public static void main(String[] args)  throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
                String s = sv.requestCharacter("B21DCCN053", "KkihaRAB");
                String res = URLEncoder.encode(s, "UTF-8");
                sv.submitCharacter("B21DCCN053", "KkihaRAB",res);

    }
}
