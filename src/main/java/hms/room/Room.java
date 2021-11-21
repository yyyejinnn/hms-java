
package hms.room;

import java.io.FileOutputStream;
import java.io.IOException;

public class Room {  //객실 클래스
    private int idx;  //객실 번호
    private int roomAmount;   //객실 가격
    private int maxPeopleNum;  //최대 인원수
    private boolean roomClean;  //점유 여부

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(int roomAmount) {
        this.roomAmount = roomAmount;
    }

    public int getMaxPeopleNum() {
        return maxPeopleNum;
    }

    public void setMaxPeopleNum(int maxPeopleNum) {
        this.maxPeopleNum = maxPeopleNum;
    }  

    public boolean isRoomClean() {
        return roomClean;
    }

    public void setRoomClean(boolean roomClean) {
        this.roomClean = roomClean;
    }
    
    
}
