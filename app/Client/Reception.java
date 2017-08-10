
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.net.Socket;

public class Reception implements Runnable
{
 private Socket socket; 
 private BufferedReader in;
 private String message;
 private DataInputStream  streamInput ;
    private Client c;

 public Reception(Socket socket, Client c)
 {
  System.out.println("Socket creation");
  this.socket = socket;
     this.c = c;
 }
 public void run()
 {
  System.out.println("Thread launching");
     boolean run = false;
     while(run == false)
     {
         try
         {
             streamInput = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
             in = new BufferedReader(new InputStreamReader(streamInput));
             while(true)
             {
             message = in.readLine();
                 
             // Get the id of the client
             if(message.contains("/yourId"))
             {
                 String stringId = message.substring(8);               int idFInal =Integer.parseInt(stringId);
                 c.setId(idFInal);
             }
             else if(message.contains("/uploadTo"))
             {
                 // dividing the String
                 String stringId = message.substring(10);
                 // Split in a tab to extract info
                 
                 String[] tabInfo = stringInfo.split(" ");
                 int idToDownload = Integer.parseInt(tabInfo[1]);
                 int listeningPort = Integer.parseInt(tabInfo[2]);
                 String ipAddress = tabInfo[3];
                 
                 // Creation of the socket
                 
                 Socket socket2 = new Socket(ipAddress, listeningPort);
                 
             }
             else if(!message.equals(null))
             {
                 System.out.println(message);
             }
             }
             
         }
         catch (IOException e)
         {
             e.printStackTrace();
         }
     }
 }
}
