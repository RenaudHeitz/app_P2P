
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
    private String message = null;
    private  PrintWriter out;

    
    public Send(Socket s) {
        System.out.println("Creation of the sending socket");
        this.socket = s;
    }
    
    public void run() {
        System.out.println("Sending thread launching");
        Connected C = new Connected(socket);
        C.add(C);
        
        int idClient = Connected.connectedList.indexOf(C);
        try
        {
            out = new PrintWriter(socket.getOutputStream());
            out.println("/yourId " + idClient );
            out.flush();
        }
        catch(IOException ioe)
        {
            System.out.println("Erreur : " + ioe.getMessage());
        }
    }
    
   
}
