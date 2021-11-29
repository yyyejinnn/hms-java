
package hms.check;
import hms.check.CheckDrive;
import hms.room.Reserve;
<<<<<<< HEAD

=======
import hms.textfiles.CheckTextFiles;
>>>>>>> 06b6abb984bf5b978e96fd4150936bf6e1958a0a
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
