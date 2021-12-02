
package hms.check;

import hms.object.Reserve;
import hms.textfiles.CheckTextFiles;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author LYJ
 */
public class CheckInSrc extends CheckSrc{
    public void checkIn(ArrayList<Reserve> checkInList) throws IOException {  //체크인
        CheckTextFiles.setCheckinListTxt(checkInList);  //체크인 txt에 추가
        CheckTextFiles.deleteReserveListTxt(checkInList); // 예약목록 txt에서 삭제
        CheckTextFiles.updateRoomClean(checkInList.get(0).getRoomNum());//점유상태 변경 > 예약으로 옮길 것
    }
}
