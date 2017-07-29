package server;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Renaud
 */
public class ServerData extends Thread {
  private final Socket socket;
  static final ArrayList<File> listeFichier = new ArrayList<File>();
  
   //déclaration des flux d'entré
    	DataInputStream streamInput;
        BufferedReader d;
        PrintWriter out;
        String message = null; 
  public ServerData(Socket socket) {
    this.socket = socket;
  }
  
 private String retrievePublicIP() throws IOException
{
URL url = new URL("http://yveran.ephian.net/test/ipaddress.php");

HttpURLConnection con = (HttpURLConnection) url.openConnection();
InputStreamReader isr = new InputStreamReader(con.getInputStream());
BufferedReader rd = new BufferedReader(isr);

String line = rd.readLine();
rd.close();

return line;
}
  @Override
  public void run() {
      try {
          //instanciation des flux
          out = new PrintWriter(socket.getOutputStream());
      
          streamInput = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
          d = new BufferedReader(new InputStreamReader(streamInput));
          System.out.println(d.readLine());
          out.flush();
          message = d.readLine();
          
          boolean authentifier = false;
          if(listePseudoBannis.contains(name.toLowerCase())!= true)
          {
            while(authentifier== false)
                    {
                       if(listePseudo.contains(name)!=true){
                                  out.println("Bienvenu sur le Chat.\n"
                                          + " La commande /listeCo vous permet d'afficher les utilisateurs connectés\n"
                                          + "La commande /deco vous permet de vous déconnecter \n"
                                          + "La commande /ban suivie d'un pseudo permet de le bannir \n"
                                          + "Par exemple : /ban Paul");
                                  System.out.println(name +" vient de se connecter ");
                                  out.flush();
                                  authentifier = true;	
                          }
                       else
                       {
                           out.println("Ce pseudo est déjà utilisé, veuillez en taper un autre");
                       out.flush();
                       name = d.readLine();
                       }
                    }

            listePseudo.add(name);

            // Création de membre connecté, on associe son nom et sa socket

            Connecte C = new Connecte(name, socket);
            C.add(C);
          File conv = new File("Conversation.txt");
          Thread t3 = new Thread(new Reception(d,out, C, socket));
          t3.start();
          Thread t4 = new Thread(new Envoi(out,socket,conv));
          t4.start();
          }
          else out.println("Désolé ce pseudo a été bannis"); out.flush();
       
        
         }
      catch (IOException ex) {
          Logger.getLogger(ServerData.class.getName()).log(Level.SEVERE, null, ex);
      }   
      } 
}

