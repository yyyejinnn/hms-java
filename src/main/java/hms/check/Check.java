
package hms.check;

import hms.room.Reserve;
import hms.textifiles.CheckTextFiles;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Check {
    public Reserve[] check(String str, int checkType) throws IOException {  //검색
        //1. 예약 목록에서 불러옴 > 객체 배열로
        ArrayList<Reserve> reserveList = new ArrayList<>();
        Reserve[] checkInList = new Reserve[1];  //체크인 목록 저장할 배열 생성
        
        if (checkType  == 1){  //checkIn
            reserveList = CheckTextFiles.getReserveListTxt();
        } else {  //checkOut
            reserveList = CheckTextFiles.getCheckListTxt();
        }
        
        //2. 검색 후 출력
        for(Reserve r : reserveList){
            if(r.getReserveIdx() == Integer.parseInt(str)  || r.getName().matches(str)){
                System.out.println("방번호        예약자      인원수      금액");
                System.out.printf("%d             %s          %d          %d \n", r.getReserveIdx(), r.getName(), r.getReservePeopleNum(), r.getCharge()); //목록 출력
                checkInList[0] = r;
            }
        }
        return checkInList;
    }
    
    public static void pay(int charge)throws IOException{  //결제
        while(true){
            System.out.println("============================================================");
            System.out.println("                                       [결제]");
            System.out.println("============================================================");
            System.out.println("결제 금액: " + charge +"원\n");
            System.out.println(">> 결제 방법을 선택해주세요. ");
            System.out.println("1. 카드     2. 현금");
        
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            String inputLine = is.readLine();
        
            //1. 카드 결제
            if(inputLine.matches("1")){
                while(true){
                    System.out.print("카드번호 16자리를 입력해주세요.: ");
                    String cardNum = is.readLine();
                
                    if(cardNum.length() != 16){
                        continue;
                    } else{
                        System.out.println("결제 완료되었습니다.");
                        //체크인 txt 요금 0으로 변경
                        break;
                    }
                }
            //2. 현금 결제
            }else if(inputLine.matches("2")){
                while(true){
                    System.out.print("지불할 액수를 입력해주세요.: ");
                    String payed = is.readLine();
                    int payedInt = Integer.parseInt(payed);
                
                    if(charge > payedInt){
                        System.out.println("금액이 부족합니다. ");
                        continue;
                    } else{
                        System.out.println("결제 완료되었습니다.");
                        System.out.printf("거스름돈: %d \n", payedInt - charge);
                        //체크인 txt 요금 0으로 변경
                        break;
                    }
                }
            }
            break;
        }//end of while
    }
}
