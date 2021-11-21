/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.textifiles;

import hms.room.Reserve;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ddac9
 */
public class CheckTextFiles {
    
    public static ArrayList getReserveListTxt(){ //예약자 txt 불러옴
        String fileName = "reserveList.txt" ;
        ArrayList<Reserve> reserveList = new ArrayList<>();  //예약자 목록 객체
        String[] splitedStr = null;
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
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
    
    public static void setCheckinListTxt(ArrayList<Reserve> r){  //체크인 txt에 저장
        String fileName = "checkInList.txt" ;
        
        int reserveIdx = r.get(0).getReserveIdx();
        int reservePeopleNum = r.get(0).getReservePeopleNum();
        int charge = r.get(0).getCharge();
        
        String reserveIdxStr = Integer.toString(reserveIdx);
        String reservePeopleNumStr = Integer.toString(reservePeopleNum);
        String reserveName = r.get(0).getName();
        String chargeStr = Integer.toString(charge);
        
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
            String str = reserveIdxStr + "/" + reservePeopleNumStr + "/" + reserveName + "/" + chargeStr+"\n";
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
        
        } catch(IOException e){
            System.out.println(e);
        }
    }
}
