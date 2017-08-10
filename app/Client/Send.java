
import java.io.*;
import java.net.*;
import java.util.*;


public class Send implements Runnable
{
 private Socket socket; 
 private BufferedReader reader;
 private  PrintWriter out;
 private String message = null;
 private Scanner sc = null;

 public Send (Socket socket)
 {
     System.out.println("Creation of the sending socket");
     this.socket = socket;
 }
 public void run()
 {
     System.out.println("Sending thread launching");
     sc = new Scanner(System.in);

         try
         {
        // Sending the local file list to the server

         ObjectOutputStream  oos = new ObjectOutputStream(socket.getOutputStream());
           
         oos.writeObject(cFile.localFileList);
             
        // Part to send instruction to the server
             
             out = new PrintWriter(socket.getOutputStream());
             
             boolean run = false;
             while(run == false){
                 message = sc.nextLine();
                 
                 // if the client want to download a file
                 if(message.contains("/download"))
                 {
                     // We generate a random listening port to create a connection between the two clients
                     Random r = new Random();
                     int port = 5001 + r.nextInt(6000 - 5001);
                     // Creation of a new socket on this port
                    ServerSocket socket2 = new ServerSocket(port);

                     // We create a message composed of "/download idFile listeningPort"
                     message = message + " " +port;
                     out.println(message);
                     out.flush();

                 }
                 else
                 {
                     out.println(message);
                     out.flush();
                 }
             }
             
         }
         catch(UnknownHostException uhe)
         {
             System.out.println("Serveur non trouvé" + uhe.getMessage());
         }
         catch(IOException ioe)
         {
             System.out.println("Erreur : " + ioe.getMessage());
         }
  
     
 }
}
