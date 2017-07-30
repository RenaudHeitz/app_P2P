/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;


import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.net.Socket;


public class Client
{
    private Socket socket;
    private DataInputStream  streamInput ;

       private BufferedReader d2;
        private Scanner sc;
        private PrintWriter out;
    public Client(String serverName, int serverPort) throws IOException, InterruptedException
	   {
           try
           {
                   File conv = new File("Conversation.txt");
               socket = new Socket(serverName, serverPort);
               System.out.println("Connecté :" + socket);
               
               streamInput = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
               d2 = new BufferedReader(new InputStreamReader(streamInput));
                
               sc = new Scanner(System.in);
               out = new PrintWriter(socket.getOutputStream());
               out.println("Bonjour je tente de me connecter");
               out.flush();
               Thread t3 = new Thread(new ReceptionC(d2, socket, conv));
               t3.start();
               Thread t4 = new Thread(new Envoi(out,socket,conv));
	       t4.start();
               
               
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


