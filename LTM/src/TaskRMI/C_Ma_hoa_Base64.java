/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;

import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
/**
 *
 * @author admin
 */
public class C_Ma_hoa_Base64 {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN604", "aT3x7tVG");
        
        byte []tmp = Base64.getEncoder().encode(s.getBytes());
        String a = new String (tmp);
        sv.submitCharacter("B22DCCN604", "aT3x7tVG",a);
    }
}
