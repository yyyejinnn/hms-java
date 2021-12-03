/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.textfiles;

import hms.object.Dishtxt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author LYJ
 */
public class DishTextFiles extends TextFiles{
    private static String fileName = ""; //type 1:restaurantList.txt  2:roonService.txt
        
    //****restaurantLixt.txt roomServiceLixt.txt ****//
    //레스토랑, 룸 서비스 수정
    public static void updateRtRsListTxt(String menu, String fee, String updateMenu, String updateFee, int type){
        if(type == 1){
            fileName = RT_TXT_NAME;
        }else{
            fileName = RS_TXT_NAME;
        }
        
        try{
            File file = new File(fileName);
            String dummy = "";
            
            //1. 파일 읽기
            BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(file)));           
            String str = "";
            
            //2. 수정
            while((dummy = is.readLine()) != null){
                if(!(dummy.contains(menu) && dummy.contains(fee))) {
                    str += dummy + "\n";
                }else if(dummy.contains(menu)){  //해당 목록
                    dummy = dummy.replace(menu, updateMenu);
                    dummy = dummy.replace(fee, updateFee);
                    str += dummy + "\n";
                }
            }
            
            //3. 파일 덮어쓰기
            FileOutputStream fos = new FileOutputStream(fileName);  //false
            
            //FileOutputStream은 파일에 바이트 단위로 내보냄 > 바이트 변환 필요
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
        } catch(IOException e){
            System.out.println(e);
        }
    }
    
    //레스토랑, 룸 서비스 삭제
    public static void deleteRtRsListTxt(String menu, String fee, int type){
        if(type == 1){
            fileName = RT_TXT_NAME;
        }else{
            fileName = RS_TXT_NAME;
        }
        
        try{
            //1. 파일 생성
            File file = new File(fileName);
            String dummy = "";
            
            //2. 파일 읽기
            BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(file)));           
            String str = "";
            
            //체크인된 행 제외
            while((dummy = is.readLine()) != null){
                if(!(dummy.contains(menu) && dummy.contains(fee))) {
                    str += dummy + "\n";
                }
            }
            
            //3. 파일 덮어쓰기
            FileOutputStream fos = new FileOutputStream(fileName);
            
            //FileOutputStream은 파일에 바이트 단위로 내보냄 > 바이트 변환 필요
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
            
        } catch(IOException e){
             System.out.println(e);
        }
    }
    
    //레스토랑, 룸 서비스 추가
    public static void setRtRsListTxt(String menu, String fee, int type){
        if(type == 1){
            fileName = RT_TXT_NAME;
        }else{
            fileName = RS_TXT_NAME;
        }
        
        //1. 파일 객체 생성
        try{
            File file = new File(fileName);
        
            //2. 파일 존재여부 체크 및 생성
            if(!file.exists()){
                file.createNewFile();
            }
            
            //3. 파일 쓰기
            FileOutputStream fos = new FileOutputStream(fileName,true);
            
            //FileOutputStream은 파일에 바이트 단위로 내보냄 > 바이트 변환 필요
            String str = menu + "/" + fee + "\n";
            
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
        
        } catch(IOException e){
            System.out.println(e);
        }
    }

    //레스토랑 서비스 종류 txt 불러옴
    public static ArrayList getRestaurantListTxt() {
        ArrayList<Dishtxt> dishList = new ArrayList<>();
        String[] splitedStr = null;
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(RT_TXT_NAME));
            String line = null;
            
            while ((line = in.readLine()) != null) {  //라인 단위로 읽어옴
               splitedStr = line.split("/");
               
               //[0]메뉴이름 [1]가격
               dishList.add(new Dishtxt(splitedStr[0],splitedStr[1]));  //ArrayList에 저장
            }
            in.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }
        
        return dishList;
    }

    //룸서비스 서비스 종류 txt 불러옴
    public static ArrayList getRoomServiceListTxt() {
        ArrayList<Dishtxt> dishList = new ArrayList<>();
        String[] splitedStr = null;
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(RS_TXT_NAME));
            String line = null;
            
            while ((line = in.readLine()) != null) {  //라인 단위로 읽어옴
               splitedStr = line.split("/");
               
               //[0]메뉴이름 [1]가격
               dishList.add(new Dishtxt(splitedStr[0],splitedStr[1]));  //ArrayList에 저장
            }
            in.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }
        
        return dishList;
    }
    
    //****dishCustomerList.txt****//
    //서비스 이용한 고객 정보 저장
    public static void setDishCustomerListTxt(String[] dishCustomer){
        
        //1. 파일 객체 생성
        try{
            File file = new File(DISH_TXT_NAME);
        
            //2. 파일 존재여부 체크 및 생성
            if(!file.exists()){
                file.createNewFile();
            }
            
            //3. 파일 쓰기
            FileOutputStream fos = new FileOutputStream(DISH_TXT_NAME,true);
            
            //FileOutputStream은 파일에 바이트 단위로 내보냄 > 바이트 변환 필요
            //[0]방번호 [1]이름 [2]인원수 [3]서비스종류 [4]서비스가격 [5]결제요금
            String str = dishCustomer[0] + "/" +  dishCustomer[1] + "/" +  dishCustomer[2] + "/" +
                         dishCustomer[3] + "/" + dishCustomer[4] + "/" + dishCustomer[5] + "\n";
            
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
        
        } catch(IOException e){
            System.out.println(e);
        }
    }
    
    //예약된 식사 서비스 내역 불러옴
    public static ArrayList getDishCustomerListTxt() {
        ArrayList<Dishtxt> dishCustomerList = new ArrayList<>();
        String[] splitedStr = null;
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(DISH_TXT_NAME));
            String line = null;
            
            while ((line = in.readLine()) != null) {  //라인 단위로 읽어옴
               splitedStr = line.split("/");
               
               //[0]방번호 [1]이름 [2]인원수 [3]서비스종류 [4]가격 [5]객실로 청구될 금액
               dishCustomerList.add(new Dishtxt(splitedStr[0],splitedStr[1],splitedStr[2],splitedStr[3],splitedStr[4]));  //ArrayList에 저장
            }
            in.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }
        
        return dishCustomerList;
    }
    
    public static ArrayList getDishCustomerListTxt(String DishStr) {
        ArrayList<Dishtxt> dishCustomerList = new ArrayList<>();
        String[] splitedStr = null;
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(DISH_TXT_NAME));
            String line = null;
            
            while ((line = in.readLine()) != null) {  //라인 단위로 읽어옴
               splitedStr = line.split("/");
               
               if(line.contains(DishStr)) {
                    //[0]방번호 [1]이름 [2]인원수 [3]서비스종류 [4]가격 [5]객실로 청구될 금액
                    dishCustomerList.add(new Dishtxt(splitedStr[0],splitedStr[1],splitedStr[2],splitedStr[3],splitedStr[4]));  //ArrayList에 저장
               }
            }
            in.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }
        
        return dishCustomerList;
    }
    
    //선택한 목록 삭제
    public static void deleteDishCustomerListTxt(String dCustomerIdx){
        dCustomerIdx = dCustomerIdx + "/";
        
        try{
            //1. 파일 생성
            File file = new File(DISH_TXT_NAME);
            String dummy = "";
            
            //2. 파일 읽기
            BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(file)));           
            String str = "";
            
            //체크인된 행 제외
            while((dummy = is.readLine()) != null){
                if(!(dummy.contains(dCustomerIdx))) {
                    str += dummy + "\n";
                }
            }
            
            //3. 파일 덮어쓰기
            FileOutputStream fos = new FileOutputStream(DISH_TXT_NAME);
            
            //FileOutputStream은 파일에 바이트 단위로 내보냄 > 바이트 변환 필요
            byte[] content = str.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
            
        } catch(IOException e){
             System.out.println(e);
        }
    }
    
    //dishCustomerList.txt에서 요금 불러옴
    public static int getDishCharge(String roomIdx){
        String roomInxStr = roomIdx + "/";
        String[] splitedStr = null;
        int fee = 0;
        
        try{
            File file = new File(DISH_TXT_NAME);
            String dummy = "";
            
            //1. 파일 읽기
            BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(file)));           
            String charge = "";
            
            //2. 해당하는 객실 line 불러옴
            while((dummy = is.readLine()) != null){
                if(dummy.contains(roomInxStr)) {
                    splitedStr = dummy.split("/");
                    fee = Integer.parseInt(splitedStr[5]); //[5]객실로 청구될 금액
                }
            }
            
            is.close();
        } catch(IOException e){
            System.out.println(e);
        }
        
        return fee;
    }
    
}
