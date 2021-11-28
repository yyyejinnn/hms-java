
package hms.check;

import hms.room.Reserve;
import hms.textfiles.CheckTextFiles;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author LYJ
 */
public class Check {
    //검색 메소드
    public ArrayList check(String str, int checkType) throws IOException {
        //1. 예약 목록에서 불러옴 > 객체 배열로
        ArrayList<Reserve> reserveList = new ArrayList<>();
        ArrayList<Reserve> checkList = new ArrayList<>();  //체크인 목록 저장할 배열 생성
        
        if (checkType  == 1){  //checkIn
            reserveList = CheckTextFiles.getReserveListTxt();
        } else {  //checkOut
            reserveList = CheckTextFiles.getCheckListTxt();
        }
        
        //2. 검색 후 출력
        for(Reserve r : reserveList){
            //방번호 또는 예약자명이 일치하는 목록만 출력
            if(r.getReserveIdx() == Integer.parseInt(str)  || r.getName().matches(str)){                
                System.out.println("방번호    예약자        전화번호        인원수      금액         체크인        체크아웃");
                System.out.printf("%d           %s          %s             %d          %d           %s %s         %s %s \n",
                                 r.getReserveIdx(), r.getName(), r.getPhoneNum(), r.getReservePeopleNum(), r.getCharge(), r.getCheckInDate(), r.getCheckInTime(), r.getCheckOutDate(), r.getCheckOutTime());
                checkList.add(r);
            }
        }
        return checkList;
    }
}
