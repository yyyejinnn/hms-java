
package hms.room;

import java.util.Date;

public class Reserve {  //예약 목록 클래스
    private int reserveIdx;  //객실 번호
    private String name;  //예약자 이름
    private String phoneNum;  //예약자 전화번호
    private int reservePeopleNum;  //예약 인원수
    private String checkInDate;  //체크인 날짜
    private String checkInTime;  //체크인 시간
    private String checkOutDate;  //체크아웃 날짜
    private String checkOutTime;  //체크아웃 시간
    private int charge;  //총 결제 금액
    
    public Reserve(String reserveIdx, String name, String phoneNum, String reservePeopleStr, String checkInDate,
                    String checkInTime,String checkOutDate, String checkOutTime, String charge){
        this.reserveIdx = Integer.parseInt(reserveIdx);
        this.name = name;
        this.phoneNum = phoneNum;
        this.reservePeopleNum = Integer.parseInt(reservePeopleStr);
        this.checkInDate = checkInDate;
        this.checkInTime = checkInTime;
        this.checkOutDate = checkOutDate;
        this.checkOutTime = checkOutTime;
        this.charge = Integer.parseInt(charge);
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    
    public int getReserveIdx() {
        return reserveIdx;
    }

    public void setReserveIdx(int reserveIdx) {
        this.reserveIdx = reserveIdx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReservePeopleNum() {
        return reservePeopleNum;
    }

    public void setReservePeopleNum(int reservePeopleNum) {
        this.reservePeopleNum = reservePeopleNum;
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
    
    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }     
}
