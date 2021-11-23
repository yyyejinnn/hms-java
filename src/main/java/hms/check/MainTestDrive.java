
package hms.check;
import hms.check.CheckDrive;
import hms.textifiles.CheckTextFiles;
import java.io.IOException;

public class MainTestDrive {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        CheckDrive ck = new CheckDrive();
        //ck.checkInDrive();
        ck.checkOutDrive();
    }
    
}
