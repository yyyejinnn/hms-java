
package hms.textfiles;

import hms.room.Reserve;
import hms.room.Dishtxt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author LYJ
 */
public class DishTextFiles {
    public static final String RT_TXT_NAME = "restaurantList.txt";
    public static final String DISH_TXT_NAME = "dishCustomerList.txt";
    
    //레스토랑 서비스 목록 불러옴
    public static ArrayList getRestaurantListTxt() {
        ArrayList<Dishtxt> dishList = new ArrayList<>();
        String[] splitedStr = null;
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(RT_TXT_NAME));
            String line = null;
            
            while ((line = in.readLine()) != null) {  //라인 단위로 읽어옴
               splitedStr = line.split("/");
               
               //[0]메뉴이름 [1]가격
               dishList.add(new Dishtxt(splitedStr[0],splitedStr[1]));  //ArrayList에 저장
            }
            in.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }
        
        return dishList;
    }
    
     public static void setDishCustomerListTxt(String[] dishCustomer){
        
        //1. 파일 객체 생성
        try{
            File file = new File(DISH_TXT_NAME);
        
            //2. 파일 존재여부 체크 및 생성
            if(!file.exists()){
                file.createNewFile();
            }
            
            //3. 파일 쓰기
            FileOutputStream fos = new FileOutputStream(DISH_TXT_NAME,true);
            
            //FileOutputStream은 파일에 바이트 단위로 내보냄 > 바이트 변환 필요
            //[0]방번호 [1]이름 [2]인원수 [3]서비스종류 [4]서비스가격 [5]결제요금
            String str = dishCustomer[0] + "/" +  dishCustomer[1] + "/" +  dishCustomer[2] + "/" +
                         dishCustomer[3] + "/" + dishCustomer[4] + "/" + dishCustomer[5] + "\n";
            
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
        
        } catch(IOException e){
            System.out.println(e);
        }
    }
}
