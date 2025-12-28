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
public class C_Chuyen_doi_la_ma {
    public static long trans(char c ){
        if(c=='I') return 1;
        else if(c =='V') return 5;
        else if(c =='X') return 10;
        else if(c =='L') return 50;
        else if(c =='C') return 100;
        else if(c =='D') return 500;
        return 1000;
    }
    public static void main(String[] args) throws  Exception{
        String studentCode = "B21DCCN008";
        String qCode = "Xidb0Thk";
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter(studentCode, qCode);
        int n =s.length();
        long tong =0;
        tong += trans(s.charAt(n-1));
        for(int i =n-2;i>=0;i--){
            if (trans(s.charAt(i+1)) > trans(s.charAt(i)) ){
                tong -= trans(s.charAt(i));
            } else tong += trans(s.charAt(i));
        }
        sv.submitCharacter(studentCode, qCode, String.valueOf(tong));
    }
        
}
