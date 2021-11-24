
package hms.room;

import java.util.Date;

public class Reserve {  //예약 목록 클래스
    private int reserveIdx;  //객실 번호
    private String name;  //예약자 이름
    private int reservePeopleNum;  //예약 인원수
    //private Date checkcIn;  //체크인 날짜
    //private Date checkOut;  //체크아웃 날짜
    private int charge;  //총 결제 금액

    
    public Reserve(String a, String b, String c, String d){
        this.reserveIdx = Integer.parseInt(a);
        this.name = b;
        this.reservePeopleNum = Integer.parseInt(c);
        this.charge = Integer.parseInt(d);
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
/*
    public Date getCheckcIn() {
        return checkcIn;
    }

    public void setCheckcIn(Date checkcIn) {
        this.checkcIn = checkcIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
*/
    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }
    
    
}
