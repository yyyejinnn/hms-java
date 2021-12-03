/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.usercontrol;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.nio.charset.Charset;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author HOME
 */
public class UserControlSrc {
    
    File UserIDlist = new File("UserIDlist.txt");
    
    //UserIDlist.txt 파일 읽어오기 
    public ArrayList fileread() throws FileNotFoundException, IOException
    {
        
        BufferedReader br = new BufferedReader(new FileReader(UserIDlist, Charset.forName("UTF-8")));
        ArrayList<String> str = new ArrayList<String>();
        String strtest = null;
        while((strtest = br.readLine()) != null) {
        str.add(strtest);
        }
        return str;
    }
    
    //로그인 ID , Password 확인
    public int loginLogic(int num, String id, String password) {
        int success = 0;
        int falseNum = 0;
        try {
            
            if(num == 1) {
                ArrayList<String> str = new ArrayList<String>();
                str = fileread();
                for(int i = 1; i<str.size();i++)
                {
                    StringTokenizer st = new StringTokenizer(str.get(i), "/");
                    st.nextToken();
                    String checkid=st.nextToken();
                    String checkpassword=st.nextToken();
                    if(checkid.equals(id) && checkpassword.equals(password))
                    {
                        success = 1;
                        break;
                    }
                    else {
                        falseNum ++;
                    }
                    if(falseNum == str.size()-1) {
                        JOptionPane.showMessageDialog(null, "아이디 또는 패스워드가 틀립니다.");
                    }
                }


            }
            else if(num == 2) {
                ArrayList<String> str = new ArrayList<String>();
                str = fileread();
                StringTokenizer st = new StringTokenizer(str.get(0), "/");
                st.nextToken();
                String checkid=st.nextToken();
                String checkpassword=st.nextToken();
                if(checkid.equals(id) && checkpassword.equals(password))
                {
                    success = 2;
                }
                else {
                    JOptionPane.showMessageDialog(null, "아이디 또는 패스워드가 틀립니다.");
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        
        return success;
    }
    
    //UserIDlist.txt에 계정 생성
    public int createid(String id, String password)
    {
        int successnum = 0;
        try {
            int idDoubleCheckNum=0;
            
            ArrayList<String> str = new ArrayList<String>();
            str = fileread();
            String[] addNewstr = new String[str.size()+1];
            
            for(String r : str)
            {
                StringTokenizer st = new StringTokenizer(r, "/");
                st.nextToken();
                if(st.nextToken().equals(id))
                {
                    idDoubleCheckNum++;
                    break;
                }
                st.nextToken();
            }
            
            if(id.length()<4 && password.length()<4) {
                JOptionPane.showMessageDialog(null, "아이디 또는 패스워드는 4자리 이상이 되야 합니다.");
            }
            else if(getLastLineNum()>=100) {
                JOptionPane.showMessageDialog(null, "계정을 100개 이상 만들수없습니다.");
            }
            else if(idDoubleCheckNum != 0) {
                JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다.");
            }
            else {
                BufferedWriter bw = new BufferedWriter(new FileWriter(UserIDlist, Charset.forName("UTF-8"),false));
                successnum = 1;
                int newUserNum = 0;
                
                //새로추가될 계정의 번호 = i
                for(String r : str)
                {
                    
                    StringTokenizer st = new StringTokenizer(r, "/");
                    int number = Integer.parseInt(st.nextToken());
                    
                    if(number != newUserNum)
                    {
                        break;
                    }
                    newUserNum++;
                }
                
                addNewstr[0] = str.get(0);
                for(int i = 1; i< newUserNum; i++)
                {
                    addNewstr[i] = "\r\n" + str.get(i);
                }
                addNewstr[newUserNum] = "\r\n"+ newUserNum + "/" + id + "/" + password;
                for(int i= newUserNum+1;i<str.size()+1;i++)
                {
                    addNewstr[i] = "\r\n" + str.get(i-1);
                }
                
                for(String r:addNewstr) {
                    bw.write(r);
                }

                bw.flush();
                bw.close();
                
                
                JOptionPane.showMessageDialog(null, "계정이 생성되었습니다.");
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return successnum;
    }
    public int getLastLineNum() throws IOException
    {
        return fileread().size();
    }
    
    //선택한 계정 현재 아이디 가져오기
    public String setNowId(int row) {
        String nowline = null;
        String nowId = null;
        Object forcheckid = null;
        try{
        forcheckid = fileread().get(row);
        nowline = forcheckid.toString();
        
        StringTokenizer st = new StringTokenizer(nowline, "/");
        st.nextToken();
        nowId = st.nextToken();
       
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return nowId;
    }
    //선택한 계정 현재 비밀번호값 가져오기
     public String setNowPassword(int row) {
        String nowline = null;
        String nowPassword = null;
        Object forcheckid = null;
        try{
        forcheckid = fileread().get(row);
        nowline = forcheckid.toString();
        
        StringTokenizer st = new StringTokenizer(nowline, "/");
        st.nextToken();
        st.nextToken();
        nowPassword = st.nextToken();
       
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return nowPassword;
    }
     
    //UserIDlist.txt에 아이디 패스워드 수정
    public int editingUser(int row,String inputid, String inputpassword) {
        int successnum = 0;
        int rowNum = row;
        
        try {
            ArrayList<String> str = new ArrayList<String>();
            str = fileread();
            
            int idDoubleCheckNum=0;
            
            String[] forEditstr = new String[str.size()];
            
            for(String r: str)
            {
                StringTokenizer st = new StringTokenizer(r, "/");
                st.nextToken();
                if(st.nextToken().equals(inputid))
                {
                    idDoubleCheckNum++;
                    break;
                }
                st.nextToken();
            }
            
            if(inputid.length()<4 && inputpassword.length()<4) {
                JOptionPane.showMessageDialog(null, "아이디 또는 패스워드는 4자리 이상이 되야 합니다.");
            }
            else if(idDoubleCheckNum != 0) {
                JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다.");
            }
            else {
                successnum = 1;
                BufferedWriter bw = new BufferedWriter(new FileWriter(UserIDlist, Charset.forName("UTF-8"),false));
                
                if(rowNum == 0)
                {
                    String editedUser = String.format("%d/%s/%s",rowNum, inputid,inputpassword);
                    forEditstr[0] = editedUser;
                    for(int i = row+1; i<str.size(); i++) {
                        forEditstr[i] = "\r\n" + str.get(i);
                    } 
                }
                else {
                    String editedUser = String.format("\r\n%d/%s/%s",rowNum, inputid,inputpassword);
                    forEditstr[0] = str.get(0);
                    for(int i = 1; i<rowNum;i++) {
                        forEditstr[i] = "\r\n" + str.get(i);
                    }
                    forEditstr[row] = editedUser;
                    for(int i = row+1; i<str.size(); i++) {
                        forEditstr[i] = "\r\n" + str.get(i);
                    }
                }
                for(String r:forEditstr) {
                    bw.write(r);
                }

                bw.flush();
                bw.close();
                
                JOptionPane.showMessageDialog(null, "계정이 수정되었습니다.");
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return successnum;
    }
    //계정 삭제
    public void deleteUser (int row) {
        int rowNum = row;
        
        try {
            ArrayList<String> str = new ArrayList<String>();
            str = fileread();
            String[] forEditstr = new String[str.size()-1];
            BufferedWriter bw = new BufferedWriter(new FileWriter(UserIDlist, Charset.forName("UTF-8"),false));
            
                forEditstr[0] = str.get(0);
                for(int i = 1; i<rowNum;i++) {
                    forEditstr[i] = "\r\n" + str.get(i);
                }
                for(int i = rowNum; i<str.size()-1; i++) {
                    forEditstr[i] = "\r\n" + str.get(i+1);
                }
            
            for(String r:forEditstr) {
                    bw.write(r);
                }

                bw.flush();
                bw.close();
                
                JOptionPane.showMessageDialog(null, "계정이 삭제되었습니다.");
            
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
