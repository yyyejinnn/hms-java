
package hms.check;

import hms.room.Reserve;
import hms.textifiles.CheckTextFiles;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Check {
    public void check(String str) throws IOException {  //검색-1.객실번호
        //1. 예약 목록에서 불러옴 > 객체 배열로
        ArrayList<Reserve> reserveList = CheckTextFiles.getReserveListTxt();
        ArrayList<Reserve> checkInList = new ArrayList<>();
        
        //2. 검색
        for(Reserve r : reserveList){
            if(r.getReserveIdx() == Integer.parseInt(str)  || r.getName().matches(str)){
                System.out.println("방번호        예약자      인원수      금액");
                System.out.printf("%d             %s          %d          %d \n", r.getReserveIdx(), r.getName(), r.getReservePeopleNum(), r.getCharge()); //목록 출력
                checkInList.add(r);
            }
        }
        
        //3. 체크인
        System.out.println();
        System.out.print(">>체크인 하시겠습니까?(y/n): ");
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = is.readLine();
        
        
        if(inputLine.matches("y")){
            CheckTextFiles.setCheckinListTxt(checkInList);  //체크인 txt에 추가
            // 예약목록 txt에서 삭제
        } else{
            System.out.print("error");
        }
        
    }
    
    public int pay(int roomNum){  //결제
        //return charge;
        return 1;
    }
}
