package HTM;
import java.util.Scanner;

public class System {    
    int Revenue ;        //일정 기간동안의 수익률   
    
    int GuestRoomPay = 250000;         //객실 요금 선언
    int GuestPay = 0;            //고객이 객실 요금을 제외한 사용 페이 선언
    int TotalPay =0;            //모든 가격
    
    int SystemChoice;               //예외값 선택
    
    int RandomNumber =(int)(Math.random()*100) ;        //난수 생성
    
    void Exception(){ //객실과 식사서비스에 대한 예외 보고서를 저장한다
        
       Scanner sc = new Scanner(System.in);
       
       System.out.println("1.객실값 예외 2.식사서비스는 예외 3,객실 및 식사서비스 예외");
        SystemChoice = sc.nextInt();
        if(SystemChoice==1){
            System.out.println("객실값 예외가 저장되었습니다.");
        }
        else if(SystemChoice==2){
            System.out.println("식사서비스는 예외가 저장되었습니다.");
        }
        else if(SystemChoice==3){
            System.out.println("객실 및 식사서비스 예외가 저장되었습니다.");
        }                  
    }
     
    void Occupy(){    //일정 기간동안의 예상 점유율 표시
        
        System.out.println("일정 기간동안의 점유율은 %d 입니다.",RandomNumber);
        
    }
    int Revenue(){  //일정 기간동안의 수익률
        
        TotalPay=GuestRoomPay+GuestPay;
        
        System.out.println("일정 기간동안의 수익률은 %d 입니다.",TotalPay);
        return TotalPay;
    }
}
