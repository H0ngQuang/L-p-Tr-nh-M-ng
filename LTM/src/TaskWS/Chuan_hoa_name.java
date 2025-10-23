/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskWS;

import java.util.*;
import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

/**
 *
 * @author Admin
 */
public class Chuan_hoa_name {
    public static void main(String[] args) throws Exception {
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();

        // Bước 1: Gọi requestCharacter để lấy chuỗi từ server
        String s = port.requestString("B22DCCN652", "BJWNTTi0");
        String[] w= s.trim().toLowerCase().split("[ _]+");
        String pascalCase = "";
        String camelCase = "";
        String snake_case = "";
        int n = w.length;
        
        for(int i =0;i<n;i++){
            if(i==0) camelCase+= w[i];
            else{
                camelCase+= Character.toUpperCase(w[i].charAt(0)) + w[i].substring(1);
            }
            pascalCase += Character.toUpperCase(w[i].charAt(0)) + w[i].substring(1);
            snake_case += w[i];
            if(i!=n-1) snake_case +="_";
        }
                List<String> res = new ArrayList<>();
            res.add(pascalCase);
            res.add(camelCase);
            res.add(snake_case);
        port.submitCharacterStringArray("B22DCCN652", "BJWNTTi0", res);
            // Bước 2: Chuẩn hoá các từ (có thể phân tách bằng dấu cách hoặc gạch dưới)
    }
}

//[Mã câu hỏi (qCode): BJWNTTi0].  Một dịch vụ web được định nghĩa và mô tả trong tệp CharacterService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl để xử lý các bài toán về chuỗi và ký tự.
//Yêu cầu: Viết chương trình tại máy trạm (WS client) để giao tiếp với CharacterService thực hiện các công việc sau:
//a. Triệu gọi phương thức requestString với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một chuỗi (String) từ server. Chuỗi có thể chứa các từ được phân tách bằng dấu cách hoặc dấu gạch dưới.
//b. Chuyển đổi chuỗi đã nhận được sang ba định dạng khác nhau:
//•	PascalCase: Mỗi từ bắt đầu bằng chữ in hoa, không có khoảng cách giữa các từ.
//•	camelCase: Từ đầu tiên viết thường, các từ tiếp theo viết hoa chữ cái đầu và viết liền nhau.
//•	snake_case: Các từ được viết thường và nối với nhau bằng dấu gạch dưới.
//c. Triệu gọi phương thức submitCharacterStringArray(String studentCode, String qCode, List<String> data) để gửi mảng kết quả chứa ba chuỗi đã định dạng trở lại server, theo thứ tự: PascalCase, camelCase, snake_case.
//Ví dụ: Nếu chuỗi nhận được từ phương thức requestCharacter là "hello world example", các chuỗi kết quả sẽ là:
//•	PascalCase: "HelloWorldExample"
//•	camelCase: "helloWorldExample"
//•	snake_case: "hello_world_example"
//Mảng kết quả sẽ là ["HelloWorldExample", "helloWorldExample", "hello_world_example"], và sẽ được gửi lại server qua phương thức submitCharacter.
//d. Kết thúc chương trình client.