
package hms.check;

import hms.room.Reserve;
import hms.textifiles.CheckTextFiles;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author LYJ
 */
public class CheckIn extends Check{
    public void checkIn(ArrayList<Reserve> checkInList) throws IOException {  //체크인
        System.out.println();
        System.out.print(">>체크인 하시겠습니까?(y/n): ");
        
        //사용자 입력
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = is.readLine();
        
        //체크인 진행
        if(inputLine.matches("y")){
            CheckTextFiles.setCheckinListTxt(checkInList);  //체크인 txt에 추가
            CheckTextFiles.deleteReserveListTxt(checkInList); // 예약목록 txt에서 삭제
            CheckTextFiles.updateRoomClean(checkInList.get(0).getReserveIdx());//점유상태 변경
            this.pay(checkInList.get(0).getCharge()); // 결제
        } else{
             System.out.print("error"); //메인 화면으로 돌아가기로 수정필요
        }
    }
}
