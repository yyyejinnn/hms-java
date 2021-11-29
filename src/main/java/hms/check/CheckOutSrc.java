
package hms.check;

import hms.room.Reserve;
import hms.textfiles.CheckTextFiles;
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
public class CheckOutSrc extends CheckSrc{
    BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
    
    public void checkOut(ArrayList<Reserve> checkOutList) throws IOException{  //체크아웃
            CheckTextFiles.deleteCheckInListTxt(checkOutList); //체크인 목록 txt에서 삭제
            CheckTextFiles.setCheckOutListTxt(checkOutList);//체크아웃 목록 txt에 추가
            CheckTextFiles.updateRoomClean(checkOutList.get(0).getReserveIdx()); //점유상태 변경
    }   
    
    //요금
    public int[] pay(ArrayList<Reserve> checkOutList)throws IOException{  //결제       
        //[0]기본요금 FEE [1]추가요금 ADD_FEE [2]식사서비스 FOOD_FEE
        int[] feeArray = {0, 0, 0};
        
        //feeArray[0] = checkOutList.get(0).getCharge();
        feeArray[0] = 20000;
        feeArray[2] = 10000;
        
        //오전 11시 이후 체크아웃 시, 1박 추가 요금 청구
        LocalDate nowDate = LocalDate.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        String formatedNowDate = nowDate.format(formatterDate); //현재 날짜
        LocalTime nowTime = LocalTime.now();
        int nowHour = nowTime.getHour(); //현재 시간
        String checkOutDate = checkOutList.get(0).getCheckOutDate();  //예상 체크아웃 날짜
        
        if (checkOutDate.equals(formatedNowDate)){  //예상 체크아웃 날짜가 오늘이면
            if(nowHour >= 11){  //오전 11시 이후
                feeArray[1] += feeArray[0];  //1박 요금 추가
            }
        } else {
            System.out.println("예상 체크인 날짜가 아닙니다.");
        }
        
        return feeArray;
    }
    
    public String feedback() throws IOException {
        System.out.println("피드백 입력");
        
        String inputLine = is.readLine();
        
        return inputLine;
    }
}
