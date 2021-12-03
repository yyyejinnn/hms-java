
package hms.object;

import java.util.ArrayList;

/**
 *
 * @author PCB, LYJ
 */

public class Reserve {  //예약 목록 클래스
    private ArrayList<Reserve> reserList = new ArrayList<>();
    private String reservationNum;  // 예약번호
    private String roomNum;  //객실 번호
    private String name;  //예약자 이름
    private String phoneNum;  //예약자 전화번호
    private String peopleNum;  // 인원수
    private String checkInDate;  //체크인 날짜
    private String checkInTime;  //체크인 시간
    private String checkOutDate;  //체크아웃 날짜
    private String checkOutTime;  //체크아웃 시간
    
    //예약
    public Reserve(String reservationNum, String roomNum, String name, String phoneNum, String peopleNum, String expCheckinDate, String expCheckinTime, String expCheckoutDate, String expCheckoutTime) {
        this.reservationNum = reservationNum;
        this.roomNum = roomNum;
        this.name = name;
        this.phoneNum = phoneNum;
        this.peopleNum = peopleNum;
        this.checkInDate = expCheckinDate;
        this.checkInTime = expCheckinTime;
        this.checkOutDate = expCheckoutDate;
        this.checkOutTime = expCheckoutTime;
    }
    
    //체크인, 체크아웃
    public Reserve(String roomNum, String name, String phoneNum, String  peopleNum, String checkInDate,
                    String checkInTime, String checkOutDate, String checkOutTime){
        this.roomNum = roomNum;
        this.name = name;
        this.phoneNum = phoneNum;
        this. peopleNum =  peopleNum;
        this.checkInDate = checkInDate;
        this.checkInTime = checkInTime;
        this.checkOutDate = checkOutDate;
        this.checkOutTime = checkOutTime;
    }

    public Reserve(String roomNum, String name, String phoneNum, String  peopleNum, String checkOutDate, String checkOutTime){
        this.roomNum = roomNum;
        this.name = name;
        this.phoneNum = phoneNum;
        this. peopleNum = peopleNum;
        this.checkOutDate = checkOutDate;
        this.checkOutTime = checkOutTime;
    }

    public ArrayList<Reserve> getReserList() {
        return reserList;
    }

    public void setReserList(ArrayList<Reserve> reserList) {
        this.reserList = reserList;
    }

    public String getReservationNum() {
        return reservationNum;
    }

    public void setReservationNum(String reservationNum) {
        this.reservationNum = reservationNum;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(String peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
    
}
