/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author asdf0
 */
public class Reservation {

    int reservationNum = 0;     // 예약 번호
    int roomNum;                // 객실 번호
    String roomType;            // 객실 타입
    String customerName;        // 고객 이름
    String customerPhoneNum;    // 고객 전화번호
    int reservationPeopleNum;   // 인원 수
    int optionNum;              //메뉴 번호

    boolean usingRoom;          // 방 사용 여부
    String expectedCheckinDate; // 예상 체크인 날짜
    String expectedCheckinTime; // 예상 체크인 시간
    String expectedCheckoutDate; // 예상 체크아웃 날짜
    String expectedCheckoutTime; // 예상 체크아웃 시간

    Reservation[] reservation = new Reservation[1000];  // reservation 객체 생성
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public Reservation() {
        optionNum = 0;
    }


    public void reservationAdd() throws FileNotFoundException, UnsupportedEncodingException, IOException {  // 예약 추가

        BufferedWriter bw = new BufferedWriter(new FileWriter("Reservation.txt", true));    // 파일 열기

        String str;
        System.out.println("-------------------------------");
        System.out.println("예약 추가 ");
        System.out.println("");

        System.out.println("방 번호 입력 >> ");
        roomNum = Integer.parseInt(bf.readLine());
        System.out.println("고객 이름 입력 >> ");
        customerName = bf.readLine();
        System.out.println("고객 전화번호 입력 >> ");
        customerPhoneNum = bf.readLine();
        System.out.println("인원 수 입력 >> ");
        reservationPeopleNum = Integer.parseInt(bf.readLine());
        System.out.println("예상 체크인 날짜 (ex - 21.11.24) >> ");
        expectedCheckinDate = bf.readLine();
        System.out.println("예상 체크인 시간 (ex - 17:00) >> ");
        expectedCheckinTime = bf.readLine();
        System.out.println("예상 체크아웃 날짜 (ex - 21.11.25) >> ");
        expectedCheckoutDate = bf.readLine();
        System.out.println("예상 체크아웃 시간 (ex - 12:00) >> ");
        expectedCheckoutTime = bf.readLine();

        reservationNum++;

        str = String.format("%d/%s/%s/%d/%s/%s/%s/%s%n", roomNum, customerName, customerPhoneNum, reservationPeopleNum, expectedCheckinDate, expectedCheckinTime, expectedCheckoutDate, expectedCheckoutTime);

        bw.write(str);  /// 파일 안에 문자열 작성
        System.out.println("");
        // System.out.println(str);
        bw.close();  // 객체 종료
        bf.close();
        System.out.println("예약이 완료되었습니다.");
        System.out.println("-------------------------------");
    }

    
    
    
    public void reservationChange() throws IOException {  // 예약 변경

        File file = new File("Reservation.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        setArr();   // reservation 객체에 파일 데이터를 저장하는 함수

        System.out.println("");
        System.out.println("예약을 변경할 고객 이름 입력 >> ");
        String chCustomerName;  // 예약을 변경할 고객 이름
        chCustomerName = bf.readLine();

        int iNum = 0;
        for (int i = 0; i < 1000; i++) {  // chCustomerName(예약을 변경할 고객 이름)과 일치하는 고객 이름이 있는 인덱스찾기
            if (chCustomerName.equals(reservation[i].customerName)) {
                iNum = i;
                break;
            }
        }

        while (true) {
            int chNum;
            System.out.println("");
            System.out.println("수정 메뉴 선택 >> ");
            System.out.println("(1 : 객실 수정, 2 : 고객 이름 수정, 3: 고객 전화번호 수정, 4: 인원 수 수정, 5: 예상 체크인 날짜 수정, 6 : 예상 체크인 시간 수정, 7 : 예상 체크아웃 날짜 수정, 8 : 예상 체크아웃 시간 수정) ");
            chNum = Integer.parseInt(bf.readLine());

            if (chNum == 1) {    // 객실 수정
                System.out.println("객실 입력>>");
                reservation[iNum].roomNum = Integer.parseInt(bf.readLine());
                break;
            } else if (chNum == 2) {  // 고객 이름 수정
                System.out.println("고객 이름 입력>>");
                reservation[iNum].customerName = bf.readLine();
                break;
            } else if (chNum == 3) {  // 고객 전화번호 수정
                System.out.println("고객 전화번호 입력>>");
                reservation[iNum].customerPhoneNum = bf.readLine();
                break;
            } else if (chNum == 4) {   // 인원 수 수정
                System.out.println("인원 수 입력>>");
                reservation[iNum].reservationPeopleNum = Integer.parseInt(bf.readLine());
                break;
            } else if (chNum == 5) {   // 예상 체크인 날짜 수정
                System.out.println("예상 체크인 날짜 입력>>");
                reservation[iNum].expectedCheckinDate = bf.readLine();
                break;
            } else if (chNum == 6) {   // 예상 체크인 시간 수정
                System.out.println("예상 체크인 시간 입력>>");
                reservation[iNum].expectedCheckinTime = bf.readLine();
                break;
            } else if (chNum == 7) {   // 예상 체크인 날짜 수정
                System.out.println("예상 체크인 날짜 입력>>");
                reservation[iNum].expectedCheckoutDate = bf.readLine();
                break;
            } else if (chNum == 8) {   // 예상 체크인 시간 수정
                System.out.println("예상 체크인 시간 입력>>");
                reservation[iNum].expectedCheckoutTime = bf.readLine();
                break;
            } else {
                System.out.println("잘못 입력하셨습니다. 다시 입력하세요");
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("Reservation.txt"));
        String strr;
        int k = 0;
        int co = 0; // reservation 객체에 정보가 들어가 있는 수

        while (reservation[k].roomNum != 0) { // reservation 객체에 정보가 들어가 있는 수 세기 
            co++;
            k++;
        }

        for (int i = 0; i < co; i++) {   // 객체에 들어가있는 데이터 파일에 저장
            strr = String.format("%d/%s/%s/%d/%s/%s/%s/%s%n", reservation[i].roomNum, reservation[i].customerName, reservation[i].customerPhoneNum, reservation[i].reservationPeopleNum, reservation[i].expectedCheckinDate, reservation[i].expectedCheckinTime, reservation[i].expectedCheckoutDate, reservation[i].expectedCheckoutTime);

            bw.write(strr); // 파일에 쓰기
            // System.out.println(strr);
        }

        System.out.println("");
        System.out.println("예약 변경이 완료되었습니다.");
        System.out.println("-------------------------------");
        br.close();
        bf.close();
        bw.close();
    }

    

    
    public void reservationDelete() throws IOException {  // 예약 삭제
        BufferedWriter bw = new BufferedWriter(new FileWriter("Reservation.txt", true));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Reservation.txt")));

        int lineCount = 0;
        String str = null;

        while ((str = br.readLine()) != null) {  // 라인 수 세기
            lineCount++;
        }

        String deleteName;  // 예약을 삭제할 고객 이름
        System.out.println("");
        System.out.println("예약을 삭제할 고객 이름 입력 >> ");
        deleteName = bf.readLine();

        setArr();   // reservation 객체에 파일 데이터를 저장하는 함수

        int dNum = 0;
        for (int i = 0; i < 1000; i++) {  // 삭제할 고객의 이름의 인덱스 찾기
            if (deleteName.equals(reservation[i].customerName)) {
                dNum = i;
                break;
            }
        }

        String strrr;

        BufferedWriter bw1 = new BufferedWriter(new FileWriter("Reservation.txt"));

        // 예약을 삭제할 인덱스를 제외하고 파일에 저장
        for (int i = 0; i < dNum; i++) { // 예약을 삭제할 인덱스 전 정보까지 파일에 저장
            strrr = String.format("%d/%s/%s/%d/%s/%s/%s/%s%n", reservation[i].roomNum, reservation[i].customerName, reservation[i].customerPhoneNum, reservation[i].reservationPeopleNum, reservation[i].expectedCheckinDate, reservation[i].expectedCheckinTime, reservation[i].expectedCheckoutDate, reservation[i].expectedCheckoutTime);

            bw1.write(strrr);
            //System.out.println(strrr);
        }
        for (int i = dNum + 1; i < lineCount; i++) {   // 예약을 삭제할 인덱스 다음 정보부터 파일에 저장
            strrr = String.format("%d/%s/%s/%d/%s/%s/%s/%s%n", reservation[i].roomNum, reservation[i].customerName, reservation[i].customerPhoneNum, reservation[i].reservationPeopleNum, reservation[i].expectedCheckinDate, reservation[i].expectedCheckinTime, reservation[i].expectedCheckoutDate, reservation[i].expectedCheckoutTime);

            bw1.write(strrr);
            //System.out.println(strrr);
        }

        System.out.println("예약 삭제가 완료되었습니다.");
        System.out.println("-------------------------------");

        bw.close();
        bw1.close();
    }

    
    public void setArr() throws FileNotFoundException, IOException {  // 파일에 들어가있는 정보 reservation 객체에 저장

        for (int i = 0; i < 1000; i++) {  // 초기화 
            reservation[i] = new Reservation();
        }

        BufferedReader br = new BufferedReader(new FileReader("Reservation.txt"));

        int j = 0;
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] arr = line.split("/"); // 구분자 "/"를 사용해 나누어서 객체에 저장

            reservation[j].roomNum = Integer.parseInt(arr[0]);
            reservation[j].customerName = arr[1];
            reservation[j].customerPhoneNum = arr[2];
            reservation[j].reservationPeopleNum = Integer.parseInt(arr[3]);
            reservation[j].expectedCheckinDate = arr[4];
            reservation[j].expectedCheckinTime = arr[5];
            reservation[j].expectedCheckoutDate = arr[6];
            reservation[j].expectedCheckoutTime = arr[7];

            j++;
        }
        br.close();

    }
    
    public void reservationSearch() {}  // 예약 조회 

    public void reservationMenu() {}    // 예약 메뉴
    
}

