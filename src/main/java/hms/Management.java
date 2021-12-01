import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileReader;


public class Management {
    
    String str;
    Scanner sc = new Scanner(System.in); 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int inPut;
    int roomNum;                // 객실 번호
    String customerPhoneNum;    // 고객 전화번호
    int reservationPeopleNum;   // 인원 수
    String customerName;        // 고객 이름
    int exception;              // 예외보고서
    String expectedCheckinDate; // 예상 체크인 날짜
    String expectedCheckinTime; // 예상 체크인 시간
    String expectedCheckoutDate; // 예상 체크아웃 날짜
    String expectedCheckoutTime; // 예상 체크아웃 시간
    
    Management[] management = new Management[1000];
    
    
    void ExceptionAdd()throws FileNotFoundException, IOException{
        BufferedWriter excw = new BufferedWriter(new FileWriter("Exception.txt",true));
        BufferedReader excr = new BufferedReader(new FileReader("Exception.txt"));

        System.out.println("예외 보고서 확인할 고객의 이름을 입력하세요");
        customerName = br.readLine();
        
        System.out.println("포함되어 있지않은 잔액을 적으시오: ");               
        exception=Integer.parseInt(br.readLine());
            
        String str = String.format("%s/%d\n",customerName, exception);        
        excw.write(str);
            
        //System.out.println(str); 
        excw.close();
        
        while ((str = excr.readLine()) != null) {
            
            String[] arr = str.split("/");
            
            
            System.out.println("고객이름 : " + arr[0]);            
            System.out.println("가격 : " + arr[1]);
            
            System.out.println("----------------");

        }    
        br.close();
        excr.close();
        
      
    }
    

    void Occupancy()throws FileNotFoundException, IOException{             //예상 점유율 표시
        
        
        
        BufferedReader rv = new BufferedReader(new FileReader("Reservation.txt"));       
        System.out.println("예상 점유율 표시 : ");        

       
        while ((str = rv.readLine()) != null) {
            
            String[] arr = str.split("/");
            
            //System.out.println("방 번호 : " + arr[0]);
            System.out.println("체크인 날짜 : " + arr[4]);            
            System.out.println("체크인 시간 : " + arr[5]);
            System.out.println("체크아웃 날짜 : " + arr[6]);            
            System.out.println("체크아웃 시간 : " + arr[7]);
            System.out.println("----------------");

        }


        rv.close();
        br.close();
    }
    void Revenue()throws FileNotFoundException, IOException{             //지정된 기간동안의 방값 수익 표시
        
        String str;
           
        BufferedReader excr = new BufferedReader(new FileReader("Exception.txt"));
        BufferedReader roomr = new BufferedReader(new FileReader("dishCustomerList.txt"));
        

        BufferedReader resr = new BufferedReader(new FileReader("restaurantList.txt"));
        BufferedReader romsr = new BufferedReader(new FileReader("roomServiceList.txt"));
        
        while ((str = roomr.readLine()) != null) {
            
            String[] arr = str.split("/");                          // 방 가격  dishCustomerList
            
            System.out.println("방 가격: " + arr[4]);            

        }
        System.out.println("-------------");
        while ((str = resr.readLine()) != null) {
            
            String[] arr = str.split("/");                          //레스토랑 음식 가격    restaurantList
            System.out.println("레스토랑 음식 가격 : " + arr[1]);                                 
            
        }
        while ((str = romsr.readLine()) != null) {
            
            String[] arr = str.split("/");                          // 룸서비스 음식 가격   romsr
            System.out.println("룸서비스 음식 가격 : " + arr[1]);                                 
            
        }
        
        System.out.println("-------------");
        while ((str = excr.readLine()) != null) {
            
            String[] arr = str.split("/");
            System.out.println("예외 보고 : " + arr[1]);            //예외 값       excr
            
            
        }
        System.out.println("-------------");
        
        
        romsr.close();
        resr.close();
        roomr.close();
        excr.close();
        br.close();
    }       
    
}
