
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
public class CheckOut extends Check{
    BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
    
    public void checkOut(ArrayList<Reserve> checkOutList) throws IOException{  //체크아웃
        System.out.println();
        System.out.print(">> 체크아웃 하시겠습니까?(y/n): ");
        
        //사용자 입력
        String inputLine = is.readLine();
        
        //체크아웃 진행
        if(inputLine.matches("y")){
            CheckTextFiles.deleteCheckInListTxt(checkOutList); //체크인 목록 txt에서 삭제
            this.pay(checkOutList.get(0).getCharge()); //결제
            String feedbackStr = feedback();
            CheckTextFiles.setCheckOutListTxt(checkOutList, feedbackStr);//체크아웃 목록 txt에 추가
            CheckTextFiles.updateRoomClean(checkOutList.get(0).getReserveIdx()); //점유상태 변경
            System.out.println("\n 체크아웃 되었습니다.");
        } else{
            //메인 화면으로 돌아가기
        }
    }   
    
    @Override
    public void pay(int charge)throws IOException{  //결제
        //11시 이후 체크아웃 시, 1박 추가 요금 청구
        //
        //
        
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
    
    public String feedback() throws IOException {
        System.out.println("피드백 입력");
        
        String inputLine = is.readLine();
        
        return inputLine;
    }
}
