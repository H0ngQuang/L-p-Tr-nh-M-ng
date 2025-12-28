/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskWS;

import WS_C.CharacterService;
import WS_C.CharacterService_Service;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author admin
 */
public class C_timeROT {
      public static void main(String[] args) throws  Exception{
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        List<Integer> a = port.requestCharacter(studentCode, qCode);
        int timeRot = a.get(0)%a.size();
          Collections.rotate(a, timeRot);
         port.submitCharacterCharArray(studentCode, qCode, a);
      }
}
