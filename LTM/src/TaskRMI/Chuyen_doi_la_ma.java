/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;

import RMI.*;
import java.rmi.registry.*;

/**
 *
 * @author admin
 */
public class Chuyen_doi_la_ma {
    public  static long change1 (char c){
        if(c=='I') return 1;
        else if(c =='V') return 5; 
        else if(c =='X') return 10;
        else if(c =='L') return 50;
        else if(c =='C') return 100;
        else if(c =='D') return 500;
        return 1000;
    }
    public static long change(String s){
        long res =0;
        res += change1(s.charAt(s.length()-1));
        for(int i =s.length()-2;i>=0;i--){
            if(change1(s.charAt(i)) < change1(s.charAt(i+1))){
res -= change1(s.charAt(i));
            } else res += change1(s.charAt(i));
        }
        return res;
    }
    public static void main(String[] args)  throws Exception{
        String studentCode = "B21DCCN008";
        String qCode = "Xidb0Thk";
                Registry rg = LocateRegistry.getRegistry("203.162.10.109");

        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter(studentCode, qCode);
        sv.submitCharacter(studentCode, qCode, String.valueOf(change(s)));
    }
}
