/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.object;






import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author PCB
 */
public class Reser {
    
    private ArrayList<Reser> reserList = new ArrayList<>();
    private String reservationNum;  // 예약번호
    private String roomNum;  // 객실번호
    private String name;  // 이름
    private String phoneNum;  // 전화번호
    private String peopleNum;  // 인원수
    private String expCheckinDate;  // 예상 체크인 날짜
    private String expCheckinTime; // 예상 체크인 시간
    private String expCheckoutDate;  // 예상 체크아웃 날짜
    private String expCheckoutTime;  // 예상 체크아웃 시간
    

    // 매개변수가 있는 생성자
    public Reser(String reservationNum, String roomNum, String name, String phoneNum, String peopleNum, String expCheckinDate, String expCheckinTime, String expCheckoutDate, String expCheckoutTime) {
        this.reservationNum = reservationNum;
        this.roomNum = roomNum;
        this.name = name;
        this.phoneNum = phoneNum;
        this.peopleNum = peopleNum;
        this.expCheckinDate = expCheckinDate;
        this.expCheckinTime = expCheckinTime;
        this.expCheckoutDate = expCheckoutDate;
        this.expCheckoutTime = expCheckoutTime;
    }

    public ArrayList<Reser> getReserList() {
        return reserList;
    }

    public void setReserList(ArrayList<Reser> reserList) {
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

    public String getExpCheckinDate() {
        return expCheckinDate;
    }

    public void setExpCheckinDate(String expCheckinDate) {
        this.expCheckinDate = expCheckinDate;
    }

    public String getExpCheckinTime() {
        return expCheckinTime;
    }

    public void setExpCheckinTime(String expCheckinTime) {
        this.expCheckinTime = expCheckinTime;
    }

    public String getExpCheckoutDate() {
        return expCheckoutDate;
    }

    public void setExpCheckoutDate(String expCheckoutDate) {
        this.expCheckoutDate = expCheckoutDate;
    }

    public String getExpCheckoutTime() {
        return expCheckoutTime;
    }

    public void setExpCheckoutTime(String expCheckoutTime) {
        this.expCheckoutTime = expCheckoutTime;
    }
    
    
}
