
package hms.check;

import hms.room.Reserve;
import hms.textifiles.CheckTextFiles;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class CheckOut extends Check{
    public void checkOut(ArrayList<Reserve> checkOutList) throws IOException{  //체크아웃
        System.out.println();
        System.out.print(">> 체크아웃 하시겠습니까?(y/n): ");
        
        //사용자 입력
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = is.readLine();
        
        //체크아웃 진행
        if(inputLine.matches("y")){
            CheckTextFiles.deleteCheckInListTxt(checkOutList);// 체크인 목록 txt에서 삭제
            pay(checkOutList.get(0).getCharge());// 결제
            //String feedback = is.readLine();
            System.out.println("\n 체크아웃 되었습니다.");
        } else{
            System.out.print("error");
        }
    }   
}
