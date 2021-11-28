
package hms.check;

import hms.room.Reserve;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author LYJ
 */
public class CheckOut extends Check{
    BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
    
    public void checkOut(ArrayList<Reserve> checkOutList) throws IOException{  //체크아웃
        System.out.println();
        System.out.print(">> 체크아웃 하시겠습니까?(y/n): ");
        
        //사용자 입력
        String inputLine = is.readLine();
        
        //체크아웃 진행
        if(inputLine.matches("y")){
            //CheckTextFiles.deleteCheckInListTxt(checkOutList); //체크인 목록 txt에서 삭제
            this.pay(checkOutList); //결제
            //String feedbackStr = feedback();  //피드백 입력
            //CheckTextFiles.setCheckOutListTxt(checkOutList, feedbackStr);//체크아웃 목록 txt에 추가
            //CheckTextFiles.updateRoomClean(checkOutList.get(0).getReserveIdx()); //점유상태 변경
            System.out.println("\n 체크아웃 되었습니다.");
        } else{
            //메인 화면으로 돌아가기
        }
    }   
    
    //결제
    public void pay(ArrayList<Reserve> checkOutList)throws IOException{  //결제
        int charge = checkOutList.get(0).getCharge();  // 기본 요금
        
        //1. 오전 11시 이후 체크아웃 시, 1박 추가 요금 청구
        LocalDate nowDate = LocalDate.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        String formatedNowDate = nowDate.format(formatterDate); //현재 날짜
        LocalTime nowTime = LocalTime.now();
        int nowHour = nowTime.getHour(); //현재 시간
        String checkOutDate = checkOutList.get(0).getCheckOutDate();  //예상 체크아웃 날짜
        
        //test
        System.out.println(formatedNowDate);
        System.out.println(nowHour);
        System.out.println(charge);
        
        if (checkOutDate.equals(formatedNowDate)){  //예상 체크아웃 날짜가 오늘이면
            if(nowHour >= 11){  //오전 11시부터
                charge += 10000;  //추가 요금 //나중에 수정
            }
        } else {
            System.out.println("예상 체크인 날짜가 아닙니다.");
        }

        //2. 결제 진행
        while(true){
            System.out.println("============================================================");
            System.out.println("                                       [결제]");
            System.out.println("============================================================");
            System.out.println("결제 금액: " + charge +"원\n");
            System.out.println(">> 결제 방법을 선택해주세요. ");
            System.out.println("1. 카드     2. 현금");
        
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            String inputLine = is.readLine();
        
            //2-1. 카드 결제
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
                
            //2-2. 현금 결제
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
    
    public String feedback() throws IOException {
        System.out.println("피드백 입력");
        
        String inputLine = is.readLine();
        
        return inputLine;
    }
}
