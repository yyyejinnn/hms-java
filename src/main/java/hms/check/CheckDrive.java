
package hms.check;

import hms.room.Reserve;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author LYJ
 */
public class CheckDrive{    
    private ArrayList<Reserve> checkArrayList = new ArrayList<>();
    
    public void checkInDrive() throws IOException {
        System.out.println("============================================================");
        System.out.println("                                          [체크인]");
        System.out.println("============================================================");
        System.out.print(">> 체크인 할 객실 번호를 입력해주세요: ");
        
        //사용자 입력
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = is.readLine();
         
        //체크인 실행
        CheckIn checkIn = new CheckIn();
        checkArrayList = checkIn.check(inputLine.trim(),1);  //1: 체크인 2: 체크아웃
        
        //1. 예약 되지않은 고객일 경우
        if(checkArrayList.isEmpty()){
            System.out.println("예약이 필요 합니다.");
            return;  //예약화면으로 돌아가기
        //2. 예약 된 고객일 경우    
        } else{
            checkIn.checkIn(checkArrayList);
        }
    }
    
    public void checkOutDrive() throws IOException {
        while(true){
            System.out.println("============================================================");
            System.out.println("                                          [체크아웃]");
            System.out.println("============================================================");
            System.out.print(">> 체크아웃 할 객실 번호를 입력해주세요: ");
        
            //사용자 입력
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            String inputLine = is.readLine();
        
            //체크아웃 실행
            CheckOut checkOut = new CheckOut();
            checkArrayList = checkOut.check(inputLine.trim(),2); //1: 체크인 2: 체크아웃
        
            //1. 존재하지 않는 고객일 경우
            if(checkArrayList.isEmpty()){
                System.out.println("존재하지 않는 고객입니다.\n");
                continue;
            //2. 존재하는 고객일 경우
            } else{
                checkOut.checkOut(checkArrayList);
                break;
            }
        }
    }
}
