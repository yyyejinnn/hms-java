
package hms.textifiles;

import hms.room.Reserve;
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
public class CheckTextFiles {
    private static final String RESERVE_TXT_NAME = "reserveList.txt";
    private static final String CHECK_TXT_NAME = "checkInList.txt";
    private static final String ROOM_TXT_NAME = "roomList.txt";
    
    public static ArrayList getReserveListTxt() { //예약자 txt 불러옴
        
        ArrayList<Reserve> reserveList = new ArrayList<>();  //예약자 목록 객체
        String[] splitedStr = null;
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(RESERVE_TXT_NAME));
            String line = null;
            
            while ((line = in.readLine()) != null) {  //라인 단위로 읽어옴
               splitedStr = line.split("/");
               reserveList.add(new Reserve(splitedStr[0],splitedStr[1],splitedStr[2],splitedStr[3]));  //ArrayList에 저장
            }
            in.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }
        
        return reserveList;
    }
    
    public static void deleteReserveListTxt(ArrayList<Reserve> r){  //예약 txt에서 삭제
        int reserveIdx = r.get(0).getReserveIdx();
        String reserveIdxStr = Integer.toString(reserveIdx);
        
        try{
            //1. 파일 생성
            File file = new File(RESERVE_TXT_NAME);
            String dummy = "";
            
            //2. 파일 읽기
            BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(file)));           
            String str = "";
            
            //체크인된 행 제외
            while((dummy = is.readLine()) != null){
                if(dummy.indexOf(reserveIdxStr) < 0) {
                    str += dummy + "\n";
                }
            }
            
            //3. 파일 덮어쓰기
            FileOutputStream fos = new FileOutputStream(RESERVE_TXT_NAME);
            
            //FileOutputStream은 파일에 바이트 단위로 내보냄 > 바이트 변환 필요
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
            
        } catch(IOException e){
             System.out.println(e);
        }
    }
    
    public static void setCheckinListTxt(ArrayList<Reserve> r){  //체크인 txt에 저장         
        int reserveIdx = r.get(0).getReserveIdx();
        int reservePeopleNum = r.get(0).getReservePeopleNum();
        int charge = r.get(0).getCharge();
        
        //int > String 형변환
        String reserveIdxStr = Integer.toString(reserveIdx);
        String reserveName = r.get(0).getName();
        String reservePeopleNumStr = Integer.toString(reservePeopleNum);
        String chargeStr = Integer.toString(charge);
        
        //1. 파일 객체 생성
        try{
            File file = new File(CHECK_TXT_NAME);
        
            //2. 파일 존재여부 체크 및 생성
            if(!file.exists()){
                file.createNewFile();
            }
            
            //3. 파일 쓰기
            FileOutputStream fos = new FileOutputStream(CHECK_TXT_NAME,true);
            
            //FileOutputStream은 파일에 바이트 단위로 내보냄 > 바이트 변환 필요
            String str = reserveIdxStr + "/" + reserveName + "/" + reservePeopleNumStr + "/" + chargeStr+"\n";
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
        
        } catch(IOException e){
            System.out.println(e);
        }
    }
    
    public static ArrayList getCheckListTxt(){  //체크인 txt 목록 불러옴
        ArrayList<Reserve> reserveList = new ArrayList<>();  //예약자 목록 객체
        String[] splitedStr = null;
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(CHECK_TXT_NAME));
            String line = null;
            
            while ((line = in.readLine()) != null) {  //라인 단위로 읽어옴
               splitedStr = line.split("/");
               reserveList.add(new Reserve(splitedStr[0],splitedStr[1],splitedStr[2],splitedStr[3]));  //ArrayList에 저장
            }
            in.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }
        
        return reserveList;
    }
    
    public static void deleteCheckInListTxt(ArrayList<Reserve> r){  //체크인 txt에서 삭제
        int checkInIdx = r.get(0).getReserveIdx();
        String checkInIdxStr = Integer.toString(checkInIdx);
        
        try{
            //1. 파일 생성
            File file = new File(CHECK_TXT_NAME);
            String dummy = "";
            
            //2. 파일 읽기
            BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(file)));           
            String str = "";
            
            //체크인된 행 제외
            while((dummy = is.readLine()) != null){
                if(dummy.indexOf(checkInIdxStr) < 0) {
                    str += dummy + "\n";
                }
            }
            
            //3. 파일 덮어쓰기
            FileOutputStream fos = new FileOutputStream(CHECK_TXT_NAME);
            
            //FileOutputStream은 파일에 바이트 단위로 내보냄 > 바이트 변환 필요
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
            
        } catch(IOException e){
             System.out.println(e);
        }
    }
    
    public static void updateRoomClean(int roomIdx){  //room txt 점유상태 변경
        String roomInxStr = Integer.toString(roomIdx)+"/";
        
        try{
            File file = new File(ROOM_TXT_NAME);
            String dummy = "";
            
            //1. 파일 읽기
            BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(file)));           
            String str = "";
            
            //2. 해당 객실 사용 여부 변경
            while((dummy = is.readLine()) != null){
                if(!(dummy.contains(roomInxStr))) {
                    str += dummy + "\n";
                }else if(dummy.contains(roomInxStr)) {  //해당 객실
                    System.out.println(dummy);
                    
                    //해당 객실이 사용 중이면 비어있는 상태로 변경
                    if(dummy.contains("t")){
                        str += dummy.replace("t", "f") + "\n";
                    //해당 객실이 비어있는 상태이면 사용 중으로 변경
                    } else{
                        str += dummy.replace("f", "t") + "\n";
                    }
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
}

