package HTM;

public class CustomerInfo {
    private int RoomNum = 0;               //방 번호 선언 
    private String CustomerName ="";      //사용자 이름 선언    
    private int TotalPayment = 0;        //총 가격 선언 

    public int getRoomNum() {
        return RoomNum;
    }

    public void setRoomNum(int RoomNum) {
        this.RoomNum = RoomNum;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public int getTotalPayment() {
        return TotalPayment;
    }

    public void setTotalPayment(int TotalPayment) {
        this.TotalPayment = TotalPayment;
    }
    
    public CustomerInfo(int RoomNum,String CustomerName,int ReservationDate,int TotalPayment){
        this.RoomNum = RoomNum;
        this.CustomerName = CustomerName;
        this.TotalPayment = TotalPayment;
    }
    
    public void Show(){
        System.out.println("고객 방 번호: " + getRoomNum() );
        System.out.println("고객 이름 번호: " + getCustomerName() );
        System.out.println("고객이 내야 할 금액: " + getTotalPayment() );        
    }
    
    
    
    /*   헤더파일에 넣을것
    
    CustomerInfo[] customerInfo = new CustomerInfo[1000];
     
    for(int i=0;i<customerInfo. length;i++){
           
        System.out.println("--------------------- ");
        customerInfo[i].Show();
        }
    }
    
    */
