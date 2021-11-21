
package hms.check;

import hms.room.Reserve;
import hms.room.Room;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainTestDrive{
    public static void main(String[] args) throws IOException {
        
        System.out.println("============================================================");
        System.out.println("                              [체크인]");
        System.out.println("============================================================");
        System.out.print("체크인 할 객실 번호를 입력해주세요: ");
        
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = is.readLine();
             
        Check c1 = new Check();
        c1.check(inputLine.trim());

        }
    }
