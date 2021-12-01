package hms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;

public class Customer {
    
    int reservationNum = 0;     // 예약 번호
    int roomNum;                // 객실 번호
    String roomType;            // 객실 타입
    String customerName;        // 고객 이름
    String customerPhoneNum;    // 고객 전화번호
    int reservationPeopleNum;   // 인원 수
    int optionNum;              //메뉴 번호
    
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    void CustomerInfo()throws FileNotFoundException, IOException{
        String str;
        BufferedReader rv = new BufferedReader(new FileReader("Reservation.txt"));       
        System.out.println("고객 정보 확인 : \n");        
        
       
        while ((str = rv.readLine()) != null) {
            
            String[] arr = str.split("/");

            System.out.println("이름 : " + arr[1]);            
            System.out.println("인원수 : " + arr[3]);
            System.out.println("방번호 : " + arr[0]);            
            System.out.println("전화번호 : " + arr[2]);
            System.out.println("----------------");
        }


        rv.close();
    } 
}
