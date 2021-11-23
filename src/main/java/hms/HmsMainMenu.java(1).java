package hms;

import java.util.Scanner;

/**
 *
 * @author hesed
 */
public class HmsMainMenu {
    int countnum = 0;
    public static void main(String[] args) {
        // TODO code application logic here
        HmsMainMenu main = new HmsMainMenu();
        main.Login();
    }
    public void Login(){
        String userID = "1234";
        String userPassword = "qwer";
        String managerID = "5678";
        String managerPassword = "tyui";
        
        while(countnum < 5){
            java.lang.System.out.println("ID를 입력해주세요 : ");
            Scanner input1 = new Scanner(java.lang.System.in);
            String textID = input1.next();
            
            java.lang.System.out.println("Password를 입력해주세요 : ");
            Scanner input2 = new Scanner(java.lang.System.in);
            String textPassword = input2.next();
            
            if(userID.equals(textID) && userPassword.equals(textPassword)){
                java.lang.System.out.println("사용자님 호텔 매니저 시스템에 들어오신 것을 환영합니다.");
                countnum = 0;
                HotelSystem.User use = new HotelSystem.User();
                use.Mainmenu();
                break;
                }
            else if(managerID.equals(textID) && managerPassword.equals(textPassword)){
                java.lang.System.out.println("매니저님 호텔 매니저 시스템에 들어오신 것을 환영합니다.");
                countnum = 0;
                HotelSystem.Manager manage = new HotelSystem.Manager();
                manage.Mainmenu();
                break;
            }
            else { 
                countnum = countnum +1;
                java.lang.System.out.printf("\nID 혹은 Password가 올바르지 않습니다.(남은 횟수 %d회)\n", 5 - countnum);
                if(countnum == 5){
                    java.lang.System.out.println("로그인에 5회 이상 실패하셨기에 비정상적 접근으로 판단, 프로그램을 종료합니다.");
                    break;
                }
            }
        }
        }
    }