
package hms.check;

import hms.room.Reserve;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckDrive{    
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
        checkIn.checkIn(checkIn.check(inputLine.trim(), 1)); //1: 체크인 2: 체크아웃
        
        }
    
    public void checkOutDrive() throws IOException {
        System.out.println("============================================================");
        System.out.println("                                          [체크아웃]");
        System.out.println("============================================================");
        System.out.print(">> 체크아웃 할 객실 번호를 입력해주세요: ");
        
        //사용자 입력
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = is.readLine();
        
        //체크아웃 실행
        CheckOut checkOut = new CheckOut();
        checkOut.checkOut(checkOut.check(inputLine.trim(), 2)); //1: 체크인 2: 체크아웃
        }
    }
