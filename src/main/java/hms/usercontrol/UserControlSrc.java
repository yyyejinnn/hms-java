/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.usercontrol;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.nio.charset.Charset;

/**
 *
 * @author HOME
 */
public class UserControlSrc {
    //UserID.txt 파일 읽어오기 
    public ArrayList fileread() throws FileNotFoundException, IOException
    {
        File UserIDlist = new File("C:\\Users\\HOME\\Documents\\NetBeansProjects\\hms\\UserIDlist.txt");
        BufferedReader br = new BufferedReader(new FileReader(UserIDlist, Charset.forName("UTF-8")));
        ArrayList<String> str = new ArrayList<String>();
        String strtest = null;
        while((strtest = br.readLine()) != null) {
        str.add(strtest);
        }
        return str;
    }
}
