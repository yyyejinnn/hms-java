/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.check;
import hms.check.CheckDrive;
import java.io.IOException;

public class MainTestDrive {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        CheckDrive ck = new CheckDrive();
        ck.checkOutDrive();
    }
    
}
