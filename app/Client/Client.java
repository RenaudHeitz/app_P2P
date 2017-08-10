
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.net.Socket;


public class Client
{
 private Socket socket;
 private int id ;
 public Client(String serverName, int serverPort ) throws IOException, InterruptedException
 {
  try
  {
   socket = new Socket(serverName, serverPort);
   System.out.println("Connecté :" + socket);
   Thread t3 = new Thread(new Reception(socket, this));
   t3.start();
   Thread t4 = new Thread(new Send(socket));
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
public void setId(int i)
    {
        this.id = i;
    }
public int getId()
    {
        return id;
    }
}

