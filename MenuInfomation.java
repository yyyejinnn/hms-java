package HTM;
import java.util.Scanner;

public class MenuInformation {              //메뉴 클래스  
    

    int MenuChoice = 0 ;                // 메뉴 선택 함수
    Scanner sc = new Scanner(System.in);// 입력받는 함수 
    
    void Menu(){
        
        while(TRUE){
        System.out.println("-----------------------------");
        System.out.println("1. 예약");
        System.out.println("2. 객실 관리");
        System.out.println("3. 음식 판매 및 추적");
        System.out.println("4. ");
        System.out.println("5. 객실,요금,메뉴 관리");
        System.out.println("6. ");
        System.out.println("-----------------------------");
        
        System.out.println("진행하고자 하는 번호를 입력해주세요:");
        
        MenuChoice = sc.nextInt();
        
        
            if(MenuChoice==1){
                
            }
            else if(MenuChoice==2){
                
            }
            else if(MenuChoice==3){
                
            }
            else if(MenuChoice==4){
                
            }
            else if(MenuChoice==5){
                System.out.println("1. 객실 정보 추가");
                System.out.println("2. 객실 정보 삭제");
                System.out.println("3. 객실 정보 수정");
                System.out.println("");                
                System.out.println("4. 요금 정보 추가");
                System.out.println("5. 요금 정보 삭제");
                System.out.println("6. 요금 정보 수정");
                System.out.println("");
                System.out.println("7. 메뉴 정보 추가");
                System.out.println("8. 메뉴 정보 삭제");
                System.out.println("9. 메뉴 정보 수정");
                System.out.println("-----------------------------");
            
                System.out.println("진행하고자 하는 번호를 입력해주세요:");
                MenuChoice = sc.nextInt();
                System.out.println("-----------------------------");
                
                    if(MenuChoice==1){
                        //객실 정보 추가
                    }
                    else if(MenuChoice==2){
                        //객실 정보 삭제
                    }
                    else if(MenuChoice==3){
                        //객실 정보 수정
                    }
                    else if(MenuChoice==4){
                        //요금 정보 추가
                    }
                    else if(MenuChoice==5){
                        //요금 정보 삭제
                    }
                    else if(MenuChoice==6){
                        //요금 정보 수정
                    }
                    else if(MenuChoice==7){
                        //메뉴 정보 추가
                    }
                    else if(MenuChoice==8){
                        //메뉴 정보 삭제
                    }
                    else if(MenuChoice==9){
                        //메뉴 정보 수정
                    }
                    else{
                        System.out.println("잘못입력하였습니다.");
                        System.out.println("-----------------------------");
                    }
                
                }          
            else if(MenuChoice==6){
                
            }           
            else{
                System.out.println("잘못입력하였습니다.");
                System.out.println("-----------------------------");
            }
        }    
    }
}
