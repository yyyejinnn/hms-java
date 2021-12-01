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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
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
    
    public String setNowId(int row) {
        String nowId = null;
        Object forcheckid = null;
        try{
        /*ArrayList<String> forcheckid = new ArrayList<String>();
        forcheckid = fileread();
        String[] str = new String[forcheckid.size()];
        for(int i = 0; i < forcheckid.size() ;i++) {
            str[i] = forcheckid.get(i);
            if()
        }*/
        forcheckid = fileread().get(row);
        
        
        
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return nowId;
    }
}
