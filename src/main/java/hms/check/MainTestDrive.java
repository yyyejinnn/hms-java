
package hms.check;
import hms.check.CheckDrive;
import hms.room.Reserve;
import hms.textfiles.CheckTextFiles;
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
}
