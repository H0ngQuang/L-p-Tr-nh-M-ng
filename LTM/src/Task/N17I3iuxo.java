package Task;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class N17I3iuxo {
    public static void main(String[] args) throws IOException {
        String server = "203.162.10.109";
        int port = 2207;
        String studentCode = "B22DCCN652";
        String qCode = "17I3iuxo";
        Socket socket = new Socket(server,port);
        
        DataInputStream reader = new DataInputStream(socket.getInputStream());
        DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
        
        writer.writeUTF(studentCode+";" +qCode);
        writer.flush();
        
        String line = reader.readUTF();
        ArrayList<Integer> list = new ArrayList<>();
        String[] parts = line.trim().split(",");
        for(String i : parts){
            int x = Integer.parseInt(i);
            list.add(x);
        }
        
        int cnt =0;
        int dbt = 0;
        int prevdiff = 0;
        for(int i =1;i<list.size();i++){
            int diff = list.get(i) - list.get(i-1);
            dbt += Math.abs(diff);
            if(diff!=0){
                if(prevdiff!= 0 && (diff>0 && prevdiff<0 || diff<0 && prevdiff >0) ){
                    cnt ++;
                }
                prevdiff = diff;
            }
        } 
        writer.writeInt(cnt);
        writer.writeInt(dbt);
        System.out.println(cnt + " " + dbt);
        writer.flush();
        socket.close();
    }
}
