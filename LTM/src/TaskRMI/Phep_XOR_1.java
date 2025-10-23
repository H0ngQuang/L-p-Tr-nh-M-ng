/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package TaskRMI;
import RMI.*;
import java.rmi.registry.*;
/**
/**
 *
 * @author admin
 */
public class Phep_XOR_1 {
    public static void main(String[] args) throws  Exception{
        String studentCode = "B21DCCN008";
        String qCode = "Xidb0Thk";
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter(studentCode, qCode);
        String []s1 = s.trim().split(";");
        String res ="";
        for(int i =0;i<s1[1].length();i++){
            res += (char) (s1[1].charAt(i) ^ s1[0].charAt(i%s1[0].length()));
        }
        sv.submitCharacter(studentCode, qCode,res);
    }
}
