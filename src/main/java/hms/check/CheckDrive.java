
package hms.check;

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
             
        Check checkIn = new Check();
        checkIn.check(inputLine.trim());

        }
    
    public void checkOutDrive() throws IOException {
        System.out.println("============================================================");
        System.out.println("                                          [체크아웃]");
        System.out.println("============================================================");
        System.out.print(">> 체크아웃 할 객실 번호를 입력해주세요: ");
        
        //사용자 입력
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = is.readLine();
             
        Check checkOut = new Check();
        checkOut.checkOut(inputLine.trim());
        }
    }
