
package hms.textfiles;

import hms.room.Reserve;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author LYJ
 */
public class RecordTextFiles {
    private static final String CHECKOUT_TXT_NAME = "checkOutList.txt";
    private static final String FEEDBACK_TXT_NAME = "feedback.txt";
    
    //체크아웃 내역 txt 불러옴
    public static ArrayList getCheckOutListTxt(){
        ArrayList<Reserve> checkOutArrayList = new ArrayList<>();
        String[] splitedStr = null;
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(CHECKOUT_TXT_NAME));
            String line = null;
            
            while ((line = in.readLine()) != null) {  //라인 단위로 읽어옴
               splitedStr = line.split("/");
               
               //[0]방번호 [1]예약자명 [2]전화번호 [3]인원수 [4]실제 체크아웃날짜 [5]시간
               checkOutArrayList.add(new Reserve(splitedStr[0],splitedStr[1],splitedStr[2],splitedStr[3],splitedStr[4], splitedStr[5]));  //ArrayList에 저장
            }
            in.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }
        
        return checkOutArrayList;
    }
    
    //피드백 내역 불러옴    
    public static ArrayList getFeedbackListTxt(){
        ArrayList<String> feedbackArrayList = new ArrayList<>();  //피드백 목록 객체
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(FEEDBACK_TXT_NAME));
            String line = null;
            
            while ((line = in.readLine()) != null) {  //라인 단위로 읽어옴
              feedbackArrayList.add(line);
            }
            in.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }
        
        return feedbackArrayList;
    }
}
