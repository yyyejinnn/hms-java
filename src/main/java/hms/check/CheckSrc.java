
package hms.check;

import hms.object.Reserve;
import hms.textfiles.CheckTextFiles;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author LYJ
 */
public class CheckSrc {
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
            //방번호 또는 예약자명이 일치하는 목록 추가
            if(r.getReserveIdx() == Integer.parseInt(str)  || r.getName().equals(str)){                
              checkList.add(r);
            }
        }
        return checkList;
    }
}
