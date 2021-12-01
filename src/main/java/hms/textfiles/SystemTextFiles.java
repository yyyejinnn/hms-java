package hms.textfiles;

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
    private static final String ROOM_TXT_NAME = "roomList.txt";
    private static final String ROOM_TYPE_TXT_NAME = "roomTypeList.txt";
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
    
    //선택한 객실 삭제
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
    
    //객실 유형 txt 불러옴
    public static ArrayList getRoomTypeListTxt() {
        ArrayList<String[]> roomTypeList = new ArrayList<>();
        String[] splitedStr = null;
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(ROOM_TYPE_TXT_NAME));
            String line = null;
            
            while ((line = in.readLine()) != null) {  //라인 단위로 읽어옴
               splitedStr = line.split("/");
               
               roomTypeList.add(splitedStr);  //ArrayList에 저장
            }
            in.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }
        
        return roomTypeList;  //[0]방번호 [1]유형 [2]인원수 [3]요금
    }
    
    //객실 유형 수정
    public static void updateRoomTypeListTxt(String roomTypeIdx, String updatePeopleNum, String updateFee){        
        try{
            File file = new File(ROOM_TYPE_TXT_NAME);
            
            String[] splitedStr = null;
            String line = "";
            
            //1. 파일 읽기
            BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(file)));           
            String str = "";
            
            //2. 수정
            while((line = is.readLine()) != null){
                splitedStr = line.split("/");
                
                if(!(splitedStr[0].equals(roomTypeIdx))) {  //인덱스 일치하지 않으면
                    str += line + "\n";
                }else {  //[0]인덱스 [1]유형 [2]인원수 [3]요금
                    str += splitedStr[0] + "/" + splitedStr[1] + "/" + updatePeopleNum+ "/" + updateFee + "\n";
                }
            }
            
            //3. 파일 덮어쓰기
            FileOutputStream fos = new FileOutputStream(ROOM_TYPE_TXT_NAME);  //false
            
            //FileOutputStream은 파일에 바이트 단위로 내보냄 > 바이트 변환 필요
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
        } catch(IOException e){
            System.out.println(e);
        }
    }
    
    //객실 수정
    public static void updateRoomListTxt(String roomTypeIdx, String updatePeopleNum, String updateFee){        
        try{
            File file = new File(ROOM_TXT_NAME);
            String[] splitedStr = null;
            String line = "";
            
            //1. 파일 읽기
            BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(file)));           
            String str = "";
            
            //2. 수정
            while((line = is.readLine()) != null){
                splitedStr = line.split("/");
                
                if (splitedStr[0].startsWith(roomTypeIdx)){  //방번호가 인덱스로 시작하면
                    //[0]방번호 [1]인원수 [2]요금 [3]점유여부
                    str += splitedStr[0] + "/" + updatePeopleNum + "/" + updateFee + "/" + splitedStr[3] + "\n";
                } else{
                    str += line + "\n";
                }
            }
            
            //3. 파일 덮어쓰기
            FileOutputStream fos = new FileOutputStream(ROOM_TXT_NAME);  //false
            
            //FileOutputStream은 파일에 바이트 단위로 내보냄 > 바이트 변환 필요
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
        } catch(IOException e){
            System.out.println(e);
        }
    }
    
    
    
   /* public static void main(String[]args){
        updateRoomListTxt("1","10", "1000");
    }*/
}
