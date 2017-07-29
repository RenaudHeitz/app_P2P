/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversup;

/**
 *
 * @author Renaud
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Renaud
 */
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.net.Socket;





public class ServerSup extends Thread 
{
	private static ServerSocket server;
	private static Socket socket;
        private DataOutputStream streamOut ;
        private DataInputStream  streamIn ;


	int port = 5002;
        
        
	public ServerSup(Socket socket) throws IOException
	{
            server = new ServerSocket(port);
            
            while(true)
            {
                 try{
                     socket = server.accept();
                     System.out.print("Server has connected! \n");                       
                   

                }catch(IOException ioe){
                     System.out.print("Whoops! It didn't work! - "+ioe.getMessage()+"\n");
                }
                Thread t = new ServerData(socket);
                t.start(); 
    
            }
        }
          public static void main ( String[] args ) throws Exception
    {
        System.out.println("Démarrage du serveur");
        socket = new Socket();
            // instanciation de notre serveur sur le port 5000
            ServerSup server1 = new ServerSup(socket);

    }
}
        
            
            
            
            
            
            
		
		
	         


