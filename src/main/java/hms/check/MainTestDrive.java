
package hms.check;
import hms.check.CheckDrive;
import hms.room.Reserve;
import hms.textifiles.CheckTextFiles;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MainTestDrive {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        CheckDrive ck = new CheckDrive();
        ck.checkInDrive();
        //ck.checkOutDrive();
        //test2();
     }
    
     public static void test(){
        try{
            File file = new File("test.txt");
        
            //2. 파일 존재여부 체크 및 생성
            if(!file.exists()){
                file.createNewFile();
            }
            
            //3. 파일 쓰기
            FileOutputStream fos = new FileOutputStream("test.txt",true);
            
            //FileOutputStream은 파일에 바이트 단위로 내보냄 > 바이트 변환 필요
            String str = "2021.11.21 11:00";
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
        
        } catch(IOException e){
            System.out.println(e);
        }
    }
     
      public static void test2() throws IOException {
        
        ArrayList<String> t = new ArrayList<>();  //예약자 목록 객체
        String[] splitedStr = null;
        
        try {
            BufferedReader in = new BufferedReader(new FileReader("test.txt"));
            String line = null;
            
            while ((line = in.readLine()) != null) {  //라인 단위로 읽어옴
               splitedStr = line.split("/");
               t.add(splitedStr[0]);
               t.add(splitedStr[1]);
              }
            in.close();
            
            System.out.printf("%s %s",t.get(0), t.get(1));
            
            
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
}
