package hms.user;

import java.util.*;

public class User {
    Scanner sc = new Scanner(System.in);
	public User() {
	
	}
	
	public int mainMenu() {
		
		int num;
		
		System.out.println("---------------------------");
		System.out.println("1. 예약시스템");
		System.out.println("2. 체크인/아웃");
		System.out.println("3. 객실관리");
		System.out.println("4. 사용자관리");
		System.out.println("5. 식사 서비스 판매 및 추적");
		System.out.println("6. 시스템관리");
		System.out.println("7. 호텔시스템 종료");
		System.out.println("---------------------------");
		
		num = sc.nextInt();
		return num;
	}
	
	public void mainMenuDrive() {
		int mainNum;
		
		mainNum = mainMenu();
		
		switch(mainNum) {
			case 1:
				break;
			case 2:
				break;				
			case 3:
				//Room room = new Room();
				//room.roomState();
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
		}
				
	}

}
