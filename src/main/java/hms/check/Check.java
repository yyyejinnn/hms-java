
package hms.check;

import hms.room.Reserve;
import hms.textifiles.CheckTextFiles;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Check {
    public void check(String str) throws IOException {  //검색
        //1. 예약 목록에서 불러옴 > 객체 배열로
        ArrayList<Reserve> reserveList = CheckTextFiles.getReserveListTxt();
        Reserve[] checkInList = new Reserve[1];  //체크인 목록 저장할 배열 생성
        
        //2. 검색 후 출력
        for(Reserve r : reserveList){
            if(r.getReserveIdx() == Integer.parseInt(str)  || r.getName().matches(str)){
                System.out.println("방번호        예약자      인원수      금액");
                System.out.printf("%d             %s          %d          %d \n", r.getReserveIdx(), r.getName(), r.getReservePeopleNum(), r.getCharge()); //목록 출력
                checkInList[0] = r;
            }
        }
        
        //3. 체크인 > 나중에 CheckIn.java로 이동
        System.out.println();
        System.out.print(">>체크인 하시겠습니까?(y/n): ");
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = is.readLine();
        
        if(inputLine.matches("y")){
            CheckTextFiles.setCheckinListTxt(checkInList);  //체크인 txt에 추가
            CheckTextFiles.deleteReserveListTxt(checkInList);// 예약목록 txt에서 삭제
            Check.pay(checkInList[0].getCharge());// 결제
        } else{
            System.out.print("error");
        }
    }
    
    public void checkOut(String str) throws IOException{  //체크아웃
        ArrayList<Reserve> checkInList = CheckTextFiles.getCheckListTxt(); //체크인 txt 불러옴
        Reserve[] checkOutList = new Reserve[1];
        
        //2. 검색 후 출력
        for(Reserve r : checkInList){
            if(r.getReserveIdx() == Integer.parseInt(str)  || r.getName().matches(str)){
                System.out.println("방번호        예약자      인원수      금액");
                System.out.printf("%d             %s          %d          %d \n", r.getReserveIdx(), r.getName(), r.getReservePeopleNum(), r.getCharge()); //목록 출력
                checkOutList[0] = r;
            }
        }
        
        //3. 체크아웃 > 나중에 CheckOut.java로 이동
        System.out.println();
        System.out.print(">>체크아웃 하시겠습니까?(y/n): ");
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = is.readLine();
        
        if(inputLine.matches("y")){
            CheckTextFiles.deleteCheckInListTxt(checkOutList);// 체크인 목록 txt에서 삭제
            Check.pay(checkOutList[0].getCharge());// 결제
            
            //String feedback = is.readLine();
            
        } else{
            System.out.print("error");
        }
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
