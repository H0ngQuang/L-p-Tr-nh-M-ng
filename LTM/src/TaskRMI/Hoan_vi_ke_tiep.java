/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import RMI.*;
import java.rmi.registry.*;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Admin
 */
public class Hoan_vi_ke_tiep {
    public static void main(String[] args)throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B22DCCN568", "KSvz00fg");
        
        String []str = s.trim().split(",");
        ArrayList<Integer> a = new ArrayList<>();
        for(String i : str){
            a.add(Integer.valueOf(i.trim()));
        }
        int n = a.size();
        int i = n -1;
        while (i > 0 && a.get(i - 1) >= a.get(i)) i--;
        if(i<=0) Collections.sort(a);
        else {
            int j = n-1;
            while(a.get(j) <= a.get(i-1)) j--;
            Collections.swap(a, i-1, j);
            int l= i,r = n-1;
            while(l<r){
                Collections.swap(a,l,r);
                l++;
                r--;
            }
        }
        String res ="";
        for(int x : a){
            res += x+",";
        }
        res = res.substring(0,res.length()-1);
        sv.submitData("B22DCCN568", "KSvz00fg", res);
        
    }
}
//[Mã câu hỏi (qCode): KSvz00fg].  Một chương trình (tạm gọi là RMI Server) cung cấp giao diện cho phép triệu gọi từ xa để xử lý dữ liệu.
//Giao diện từ xa:
//public interface DataService extends Remote {
//public Object requestData(String studentCode, String qCode) throws RemoteException;
//public void submitData(String studentCode, String qCode, Object data) throws RemoteException;
//}
//Trong đó:
//•	Interface DataService được viết trong package RMI.
//•	Đối tượng cài đặt giao diện từ xa DataService được đăng ký với RegistryServer với tên là: RMIDataService.
//Yêu cầu: Viết chương trình tại máy trạm (RMI client) để thực hiện các công việc sau với dữ liệu nhận được từ RMI Server:
//a. Triệu gọi phương thức requestData để nhận một chuỗi các số nguyên.
//b. Sử dụng thuật toán sinh tổ hợp kế tiếp để tìm tổ hợp kế tiếp của chuỗi số này theo thứ tự từ điển. Nếu chuỗi đã là tổ hợp lớn nhất, trả về tổ hợp nhỏ nhất (sắp xếp lại từ đầu theo thứ tự từ điển).
//Ví dụ: Với chuỗi 1, 2, 3 tổ hợp kế tiếp là 1, 3, 2. Nếu chuỗi là 3, 2, 1 (tổ hợp lớn nhất), kết quả sẽ là 1, 2, 3 (tổ hợp nhỏ nhất).
//c. Triệu gọi phương thức submitData để gửi chuỗi chứa tổ hợp kế tiếp đã tìm được trở lại server.
//d. Kết thúc chương trình client.