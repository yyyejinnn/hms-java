
package hms.object;

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
    
    public Reserve(String reserveIdx, String name, String phoneNum, String reservePeopleStr, String checkInDate,
                    String checkInTime, String checkOutDate, String checkOutTime){
        this.reserveIdx = Integer.parseInt(reserveIdx);
        this.name = name;
        this.phoneNum = phoneNum;
        this.reservePeopleNum = Integer.parseInt(reservePeopleStr);
        this.checkInDate = checkInDate;
        this.checkInTime = checkInTime;
        this.checkOutDate = checkOutDate;
        this.checkOutTime = checkOutTime;
    }

    public Reserve(String reserveIdx, String name, String phoneNum, String reservePeopleStr, String checkOutDate, String checkOutTime){
        this.reserveIdx = Integer.parseInt(reserveIdx);
        this.name = name;
        this.phoneNum = phoneNum;
        this.reservePeopleNum = Integer.parseInt(reservePeopleStr);
        this.checkOutDate = checkOutDate;
        this.checkOutTime = checkOutTime;
    }
    
    public String getPhoneNum() {
        return phoneNum;
    }
    
    public int getReserveIdx() {
        return reserveIdx;
    }

    public String getName() {
        return name;
    }

    public int getReservePeopleNum() {
        return reservePeopleNum;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }
}
