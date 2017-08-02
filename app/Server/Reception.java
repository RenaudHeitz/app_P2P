
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Reception implements Runnable{
    
    private final Socket socket;
    
    public Reception(Socket s)
    {
        System.out.println("Creation of the reception socket");
        this.socket = s;
    }
    
    public void run()
    {
        System.out.println("Reception thread launching");
        

    }
    
    
}
