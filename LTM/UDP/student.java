package UDP;
import java.io.Serializable;
import java.util.*;

public class student implements Serializable {
    public String id,code,name,email;

    public student(String id, String code, String name,String email){
        this.id= id;
        this.code = code;
        this.name = name ;
        this.email= email;      
    }
    public student(String code){
        this.code= code;
    }
    private static final long serialVersionUID = 20171107;
    @Override
    public String toString(){
        return "Student{" + "id=" + id +", code=" + code + ", name=" + name +", email="+email+'}';
    }
}
