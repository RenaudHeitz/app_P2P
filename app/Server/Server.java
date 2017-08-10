import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.net.Socket;

public class Server extends Thread
{
    private static ServerSocket server;
    private static Socket socket;
    
    int port = 5002;
    
    
    public Server() throws IOException
    {
        server = new ServerSocket(port);
        
        while(true)
        {
            try{
                socket = server.accept();
                System.out.print("Server has connected! \n");
                // Creation of a new entry for connected client
                
                Thread recept = new Thread(new Reception(socket));
                recept.start();
                
                Thread send = new Thread(new Send(socket));
                send.start();

                
            }catch(IOException ioe){
                System.out.print("It didn't work! - "+ioe.getMessage()+"\n");
            }
            
        }
    }
}












