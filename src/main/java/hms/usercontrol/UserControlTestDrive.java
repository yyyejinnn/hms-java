/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.usercontrol;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author HOME
 */
public class UserControlTestDrive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
        UserControlSrc uc = new UserControlSrc();
        System.out.println("테스트");
        ArrayList<String> str = new ArrayList<String>();
        str = uc.fileread();
        String[] splitedstr = new String[str.size()*3];
        for(int i = 0;i <str.size();i++)
            {
                splitedstr = str.get(i).split("/");
                System.out.println(Arrays.toString(splitedstr));
            }
        
        
        
        } catch (FileNotFoundException ex) {
            System.out.println("해당파일 찾을수없음(error) : " + ex.toString());
        } catch (IOException ex) {
            System.out.println("텍스트파일에 더이상 내용이 없음(error) : " + ex.toString());
        }
    }
    
}
