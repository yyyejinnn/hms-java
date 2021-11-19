package hms;

public class Room {

    public boolean clean;                       //고객체크아웃이후에 청소된방인지아닌지
    public boolean usingRoom;                   //고객 체크인하면 true 체크아웃하면 false
    public int maxPeopleNum;                    //최대수용인원
    private int roomAmount;                     //객실가격
    public int additonalAmount;                 //추가금액

    public String customerName;                 //예약자이름
    public String customerPhoneNum;             //예약자폰번호
    public int reservationPeopleNum;            //객식에묵는총예약인원

    
    public Room() {                             //객실생성될때 기본으로 초기화되어야할 인스턴스변수들 초기화
        clean = true;                           //기본 청소된방으로하기위해 true
        usingRoom = false;                      //사용중인방아니기때문에 false
        maxPeopleNum = 4;                       //기본 최대인원 4
        roomAmount = 250000;                    //기본 객실금액 25만원
        additonalAmount = 0;                    //기본 추가금액 0원
    }
    
    public void setRoomAmount(int roomAmount) {     //객실금액 변경
        this.roomAmount = roomAmount;           
    }
    public int getRoomAmount() {                    //객실금액 가져오기
        return roomAmount;
    }
    
    public void setClean(boolean clean) {
        this.clean = clean;
    }
    public boolean getClean() {
        return this.clean;
    }
    
    public void setUsingRoom(boolean usingRoom) {
        this.usingRoom = usingRoom;
    }
    public boolean getUsingRoom() {
        return this.usingRoom;
    }
    
    public void setMaxPeopleNum(int maxPeopleNum) {
        this.maxPeopleNum = maxPeopleNum;
    }
    public int getMaxPeopleNum() {
        return this.maxPeopleNum;
    }
    
    
    
}
