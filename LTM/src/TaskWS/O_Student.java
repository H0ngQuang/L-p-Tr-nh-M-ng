/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskWS;
import WS_O.*;
import java.util.*;
/**
 *
 * @author admin
 */
public class O_Student {
    public static void main(String[] args) throws Exception{
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();
        
        List<Student> stu = port.requestListStudent("B22DCCN604", "t6BQn97a");
        List<Student> result = new ArrayList<>();
        for(Student i : stu){
            if(i.getScore() >= 8.0 || i.getScore() <= 5.0){
                result.add(i);
            }
            
            
        }
        port.submitListStudent("B22DCCN604", "t6BQn97a",result);
    }
}
