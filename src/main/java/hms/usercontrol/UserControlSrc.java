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
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.nio.charset.Charset;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author HOME
 */
public class UserControlSrc {
    
    File UserIDlist = new File("C:\\Users\\HOME\\Documents\\NetBeansProjects\\hms\\UserIDlist.txt");
    
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
    
    //UserIDlist.txt에 계정 생성
    public int createid(int num, String id, String password)
    {
        int successnum = 0;
        try {
            int idDoubleCheckNum=0;
            BufferedWriter bw = new BufferedWriter(new FileWriter(UserIDlist, Charset.forName("UTF-8"),true));
            PrintWriter pw = new PrintWriter(bw,true);
            ArrayList<String> str = new ArrayList<String>();
            str = fileread();
            
            for(String r: str)
            {
                StringTokenizer st = new StringTokenizer(r, "/");
                st.nextToken();
                //String forcheck = st.nextToken();
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
                successnum = 1;
                pw.write("\r\n"+ num + "/" + id + "/" + password);
                pw.close();
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
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(UserIDlist, Charset.forName("UTF-8"),true));
            FileWriter fw = new FileWriter(UserIDlist,false);
            int idDoubleCheckNum=0;
            ArrayList<String> str = new ArrayList<String>();
            str = fileread();
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
                String editedUser = String.format("%s/&s/%s",row, inputid, inputpassword);
                /*
                for(int i = 0; i<row;i++) {
                    forEditstr[i] = str.get(i).toString();
                }
                forEditstr[row] = editedUser;
                for(int i = row+1; i<str.size(); i++) {
                    forEditstr[i] = str.get(i).toString();
                }*/
                
               // for(String r:forEditstr) {
                //fw.write(editedUser);
                //}
                
                //fw.close();
               
                /*
                JOptionPane.showMessageDialog(null, "계정이 수정되었습니다.");
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return successnum;
     }
}
