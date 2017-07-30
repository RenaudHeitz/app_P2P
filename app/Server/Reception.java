
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Reception implements Runnable{
    
    private final Socket socket;
    
    public Reception(Socket s)
    {
        this.socket = s;
    }
    
    public void run()
    {
        
    }
    
    
}
