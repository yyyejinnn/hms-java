package hms.textfiles;

import hms.room.Reserve;
import static hms.textfiles.DishTextFiles.ROOM_TXT_NAME;
import static hms.textfiles.DishTextFiles.RS_TXT_NAME;
import static hms.textfiles.DishTextFiles.RT_TXT_NAME;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 *
 * @author LYJ
 */
public class SystemTextFiles extends DishTextFiles {
    private static String fileName = "";
    //type 1:restaurantList.txt  2:roonService.txt    
    //레스토랑, 룸 서비스 수정
    public static void updateRtRsListTxt(String menu, String fee, String updateMenu, String updateFee, int type){
        if(type == 1){
            fileName = RT_TXT_NAME;
        }else{
            fileName = RS_TXT_NAME;
        }
        
        try{
            File file = new File(fileName);
            String dummy = "";
            
            //1. 파일 읽기
            BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(file)));           
            String str = "";
            
            //2. 수정
            while((dummy = is.readLine()) != null){
                if(!(dummy.contains(menu) && dummy.contains(fee))) {
                    str += dummy + "\n";
                }else if(dummy.contains(menu)){  //해당 목록
                    dummy = dummy.replace(menu, updateMenu);
                    dummy = dummy.replace(fee, updateFee);
                    str += dummy + "\n";
                }
            }
            
            //3. 파일 덮어쓰기
            FileOutputStream fos = new FileOutputStream(fileName);  //false
            
            //FileOutputStream은 파일에 바이트 단위로 내보냄 > 바이트 변환 필요
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
        } catch(IOException e){
            System.out.println(e);
        }
    }
    
    //레스토랑, 룸 서비스 삭제
    public static void deleteRtRsListTxt(String menu, String fee, int type){
        if(type == 1){
            fileName = RT_TXT_NAME;
        }else{
            fileName = RS_TXT_NAME;
        }
        
        try{
            //1. 파일 생성
            File file = new File(fileName);
            String dummy = "";
            
            //2. 파일 읽기
            BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(file)));           
            String str = "";
            
            //체크인된 행 제외
            while((dummy = is.readLine()) != null){
                if(!(dummy.contains(menu) && dummy.contains(fee))) {
                    str += dummy + "\n";
                }
            }
            
            //3. 파일 덮어쓰기
            FileOutputStream fos = new FileOutputStream(fileName);
            
            //FileOutputStream은 파일에 바이트 단위로 내보냄 > 바이트 변환 필요
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
            
        } catch(IOException e){
             System.out.println(e);
        }
    }
    
    //레스토랑, 룸 서비스 추가
    public static void setRtRsListTxt(String menu, String fee, int type){
        if(type == 1){
            fileName = RT_TXT_NAME;
        }else{
            fileName = RS_TXT_NAME;
        }
        
        //1. 파일 객체 생성
        try{
            File file = new File(fileName);
        
            //2. 파일 존재여부 체크 및 생성
            if(!file.exists()){
                file.createNewFile();
            }
            
            //3. 파일 쓰기
            FileOutputStream fos = new FileOutputStream(fileName,true);
            
            //FileOutputStream은 파일에 바이트 단위로 내보냄 > 바이트 변환 필요
            String str = menu + "/" + fee + "\n";
            
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
        
        } catch(IOException e){
            System.out.println(e);
        }
    }
    
      
    //객실 목록 txt 불러옴
    public static ArrayList getRoomListTxt() {
        ArrayList<String[]> roomList = new ArrayList<>();
        String[] splitedStr = null;
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(ROOM_TXT_NAME));
            String line = null;
            
            while ((line = in.readLine()) != null) {  //라인 단위로 읽어옴
               splitedStr = line.split("/");
               
               roomList.add(splitedStr);  //ArrayList에 저장
            }
            in.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }
        
        return roomList;  //[0]방번호 [1]인원수 [2]요금 [3]점유여부
    }
    
     //체크인 한 고객 예약 txt에서 삭제
    public static void deleteRoomListTxt(String roomIdx){
        String reserveIdxStr = roomIdx + "/";
        
        try{
            //1. 파일 생성
            File file = new File(ROOM_TXT_NAME);
            String dummy = "";
            
            //2. 파일 읽기
            BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(file)));           
            String str = "";
            
            //체크인된 행 제외
            while((dummy = is.readLine()) != null){
                if(!(dummy.contains(reserveIdxStr))) {
                    str += dummy + "\n";
                }
            }
            
            //3. 파일 덮어쓰기
            FileOutputStream fos = new FileOutputStream(ROOM_TXT_NAME);
            
            //FileOutputStream은 파일에 바이트 단위로 내보냄 > 바이트 변환 필요
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
            
        } catch(IOException e){
             System.out.println(e);
        }
    }
    
    /*public static void main(String[]args){
        setRtRsListTxt("test100","10",1);
    }*/
}
