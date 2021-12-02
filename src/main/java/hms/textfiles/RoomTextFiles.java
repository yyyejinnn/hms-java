/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class RoomTextFiles extends TextFiles {
    //****roomLixt.txt****//
    //객실 점유상태 변경   //t:사용중, f:비어있음
    public static void updateRoomClean(String roomIdx){
        String roomInxStr = roomIdx + "/";
        
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
    
    //객실에서 요금 불러옴
    public static int getRoomCharge(String roomIdx){
        String roomInxStr = roomIdx + "/";
        String[] splitedStr = null;
        
        try{
            File file = new File(ROOM_TXT_NAME);
            String dummy = "";
            
            //1. 파일 읽기
            BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(file)));           
            String charge = "";
            
            //2. 해당하는 객실 line 불러옴
            while((dummy = is.readLine()) != null){
                if(dummy.contains(roomInxStr)) {
                    splitedStr = dummy.split("/");
                }
            }
            
            is.close();
        } catch(IOException e){
            System.out.println(e);
        }
        
        return Integer.parseInt(splitedStr[2]);  //[2]요금
    }

    //객실 목록 불러옴
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
    
    //객실 삭제
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
    
    //객실 추가
    public static void setRoomListTxt(String roomIdx){
        String[] roomTypeList = null;
        roomTypeList = getRoomTypeListTxt(roomIdx);  //해당하는 객실 유형 가져옴 [0]방번호 [1]유형 [2]인원수 [3]요금
        
        //1. 파일 객체 생성
        try{
            File file = new File(ROOM_TXT_NAME);
        
            //2. 파일 존재여부 체크 및 생성
            if(!file.exists()){
                file.createNewFile();
            }
            
            //3. 파일 쓰기
            FileOutputStream fos = new FileOutputStream(ROOM_TXT_NAME, true);  //추가
            
            //roomList에 추가 [0]방번호 [1]인원수 [2]요금 [3]점유여부
            String str = roomIdx + "/" + roomTypeList[2] + "/" + roomTypeList[3] + "/f\n";
            
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
        
        } catch(IOException e){
            System.out.println(e);
        }
    }   
    
    
    //****roomType****//
    //객실 유형 목록 불러옴
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
    
    private static String[] getRoomTypeListTxt(String idx) {
        String[] reSplitedStr = null;
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(ROOM_TYPE_TXT_NAME));
            String line = null;
             String[] splitedStr = null;
            
            while ((line = in.readLine()) != null) {  //라인 단위로 읽어옴
               splitedStr = line.split("/");
               
               if(idx.startsWith(splitedStr[0])){
                    reSplitedStr = splitedStr;
               }
            }
            in.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }
        
        return reSplitedStr;  //[0]방번호 [1]유형 [2]인원수 [3]요금
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
}
