import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.net.Socket;


public class Server extends Thread
{
    private static ServerSocket server;
    private static Socket socket;
    
    int port = 5002;
    
    
    public Server(Socket socket) throws IOException
    {
        server = new ServerSocket(port);
        
        while(true)
        {
            try{
                socket = server.accept();
                System.out.print("Server has connected! \n");
                
                
            }catch(IOException ioe){
                System.out.print("It didn't work! - "+ioe.getMessage()+"\n");
            }
            Thread recept = new Reception(socket);
            recept.start();
            
            Thread send = new Send(socket);
            send.start();
            
        }
    }
    public static void main ( String[] args ) throws Exception
    {
        System.out.println("Server launching");
        socket = new Socket();
        Server server1 = new Server(socket);
        
    }
}












