
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Send implements Runnable {
    
    private final Socket socket;
    
    public Send(Socket s) {
        this.socket = s;
    }
    
    public void run() {
        
    }
}
