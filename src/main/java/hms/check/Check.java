
package hms.check;

import hms.room.Reserve;
import hms.textifiles.CheckTextFiles;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author LYJ
 */
public class Check {
    //검색 메소드
    public ArrayList check(String str, int checkType) throws IOException {
        //1. 예약 목록에서 불러옴 > 객체 배열로
        ArrayList<Reserve> reserveList = new ArrayList<>();
        ArrayList<Reserve> checkList = new ArrayList<>();  //체크인 목록 저장할 배열 생성
        
        if (checkType  == 1){  //checkIn
            reserveList = CheckTextFiles.getReserveListTxt();
        } else {  //checkOut
            reserveList = CheckTextFiles.getCheckListTxt();
        }
        
        //2. 검색 후 출력
        for(Reserve r : reserveList){
            //방번호 또는 예약자명이 일치하는 목록만 출력
            if(r.getReserveIdx() == Integer.parseInt(str)  || r.getName().matches(str)){                
                System.out.println("방번호    예약자        전화번호        인원수      금액         체크인        체크아웃");
                System.out.printf("%d           %s          %s             %d          %d           %s %s         %s %s \n",
                                 r.getReserveIdx(), r.getName(), r.getPhoneNum(), r.getReservePeopleNum(), r.getCharge(), r.getCheckInDate(), r.getCheckInTime(), r.getCheckOutDate(), r.getCheckOutTime());
                checkList.add(r);
            }
        }
        return checkList;
    }
    
    //결제 메소드
    public void pay(int charge)throws IOException{
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
