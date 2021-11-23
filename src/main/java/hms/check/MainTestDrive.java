
package hms.check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainTestDrive{
    public static void main(String[] args) throws IOException {
        
        System.out.println("============================================================");
        System.out.println("                                          [체크인]");
        System.out.println("============================================================");
        System.out.print(">> 체크인 할 객실 번호를 입력해주세요: ");
        
        //사용자 입력
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = is.readLine();
             
        Check c1 = new Check();
        c1.check(inputLine.trim());

        }
    }
