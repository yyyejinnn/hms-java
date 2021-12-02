/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.textfiles;

import hms.object.Reserve;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author LYJ
 */
public class CheckTextFiles extends TextFiles {
    
    //****Reser.txt****//
    //예약된 고객 불러옴
    public static ArrayList getReserveListTxt() {
        ArrayList<Reserve> reserveList = new ArrayList<>();  //예약자 목록 객체
        String[] splitedStr = null;
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(RESERVE_TXT_NAME));
            String line = null;
            
            while ((line = in.readLine()) != null) {  //라인 단위로 읽어옴
               splitedStr = line.split("/");
               
               //[0]예약번호 [1]방번호 [2]예약자명 [3]전화번호 [4]인원수 [5]체크인날짜 [6]시간 [7]체크아웃날짜 [8]시간
               reserveList.add(new Reserve(splitedStr[1],splitedStr[2],splitedStr[3],splitedStr[4],splitedStr[5],
                                            splitedStr[6],splitedStr[7], splitedStr[8]));  //ArrayList에 저장
            }
            in.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }
        
        return reserveList;
    }
    
    //체크인 한 고객 예약 목록에서 삭제
    public static void deleteReserveListTxt(ArrayList<Reserve> r){
        String reserveIdx = r.get(0).getRoomNum();
        String reserveIdxStr = reserveIdx + "/";
        
        try{
            //1. 파일 생성
            File file = new File(RESERVE_TXT_NAME);
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

    //****checkInList.txt****//
    //체크인 한 고객 저장       
    public static void setCheckinListTxt(ArrayList<Reserve> r){
        String reserveIdxStr = r.get(0).getRoomNum();
        String reserveName = r.get(0).getName();
        String phoneNum = r.get(0).getPhoneNum();
        String reservePeopleNumStr = r.get(0).getPeopleNum();
        String checkInDate = r.get(0).getCheckInDate();
        String checkInTime = r.get(0).getCheckInTime();
        String checkOutDate = r.get(0).getCheckOutDate();
        String checkOutTime = r.get(0).getCheckOutTime();
        
        //1. 파일 객체 생성
        try{
            File file = new File(CHECKIN_TXT_NAME);
        
            //2. 파일 존재여부 체크 및 생성
            if(!file.exists()){
                file.createNewFile();
            }
            
            //3. 파일 쓰기
            FileOutputStream fos = new FileOutputStream(CHECKIN_TXT_NAME,true);
            
            //FileOutputStream은 파일에 바이트 단위로 내보냄 > 바이트 변환 필요
            String str = reserveIdxStr + "/" + reserveName + "/" + phoneNum + "/" + reservePeopleNumStr + "/" +
                    checkInDate + "/" + checkInTime + "/" + checkOutDate + "/" + checkOutTime + "\n";
            
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
        
        } catch(IOException e){
            System.out.println(e);
        }
    }
    
    //체크인 목록 불러옴
    public static ArrayList getCheckListTxt(){
        ArrayList<Reserve> reserveList = new ArrayList<>();  //예약자 목록 객체
        String[] splitedStr = null;
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(CHECKIN_TXT_NAME));
            String line = null;
            
            while ((line = in.readLine()) != null) {  //라인 단위로 읽어옴
               splitedStr = line.split("/");
               
               //[0]방번호 [1]예약자명 [2]전화번호 [3]인원수 [4]체크인날짜 [5]시간 [6]체크아웃날짜 [7]시간
               reserveList.add(new Reserve(splitedStr[0],splitedStr[1],splitedStr[2],splitedStr[3],splitedStr[4],
                                            splitedStr[5],splitedStr[6], splitedStr[7]));  //ArrayList에 저장
            }
            in.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }
        
        return reserveList;
    }
    
    //체크인 목록에서 삭제
    public static void deleteCheckInListTxt(ArrayList<Reserve> r){
        String checkInIdx = r.get(0).getRoomNum();
        String checkInIdxStr = checkInIdx + "/";
        
        try{
            //1. 파일 생성
            File file = new File(CHECKIN_TXT_NAME);
            String dummy = "";
            
            //2. 파일 읽기
            BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(file)));           
            String str = "";
            
            //체크인된 행 제외
            while((dummy = is.readLine()) != null){
                if(!(dummy.contains(checkInIdxStr))) {
                    str += dummy + "\n";
                }
            }
            
            //3. 파일 덮어쓰기
            FileOutputStream fos = new FileOutputStream(CHECKIN_TXT_NAME);
            
            //FileOutputStream은 파일에 바이트 단위로 내보냄 > 바이트 변환 필요
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
            
        } catch(IOException e){
             System.out.println(e);
        }
    }
    
    //****checkOutList.txt****//
    //체크아웃 내역 불러옴
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
    
    //체크아웃 한 고객 추가
    public static void setCheckOutListTxt(ArrayList<Reserve> r){
        String reserveIdxStr = r.get(0).getRoomNum();
        String reserveName = r.get(0).getName();
        String phoneNum = r.get(0).getPhoneNum();
        String reservePeopleNumStr = r.get(0).getPeopleNum();
        
        LocalDate nowDate = LocalDate.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        String formatedNowDate = nowDate.format(formatterDate); //현재 날짜
        LocalTime nowTime = LocalTime.now();
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
        String formatedNowTime = nowTime.format(formatterTime); //현재 시간
        
        //1. 파일 객체 생성
        try{
            File file = new File(CHECKOUT_TXT_NAME);
        
            //2. 파일 존재여부 체크 및 생성
            if(!file.exists()){
                file.createNewFile();
            }
            
            //3. 파일 쓰기
            FileOutputStream fos = new FileOutputStream(CHECKOUT_TXT_NAME,true);
            
            //FileOutputStream은 파일에 바이트 단위로 내보냄 > 바이트 변환 필요
           String str = reserveIdxStr + "/" + reserveName + "/" + phoneNum + "/" + reservePeopleNumStr + "/" +
                    formatedNowDate + "/" + formatedNowTime + "\n";
           
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
        
        } catch(IOException e){
            System.out.println(e);
        }
    }

    //***feedbackList.txt****//
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
    
    //고객 피드백 저장
    public static void setFeedbackListTxt(String feedbackStr){
        
        //1. 파일 객체 생성
        try{
            File file = new File(FEEDBACK_TXT_NAME);
        
            //2. 파일 존재여부 체크 및 생성
            if(!file.exists()){
                file.createNewFile();
            }
            
            //3. 파일 쓰기
            FileOutputStream fos = new FileOutputStream(FEEDBACK_TXT_NAME,true);
            
            //FileOutputStream은 파일에 바이트 단위로 내보냄 > 바이트 변환 필요
            String str = feedbackStr+ "\n";
           
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
        
        } catch(IOException e){
            System.out.println(e);
        }
    }    

}
