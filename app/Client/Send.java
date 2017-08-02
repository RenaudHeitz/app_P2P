
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.net.Socket;
import java.io.OutputStream;

public class Send implements Runnable
{
 private Socket socket; 
 private BufferedReader reader;

 public Send (Socket socket)
 {
     System.out.println("Creation of the sending socket");
  this.socket = socket;
 }
 public void run()
 {
     System.out.println("Sending thread launching");
    /* // tentative envoie arraylist au serv
     ByteArrayOutputStream bao = new ByteArrayOutputStream();
     ObjectOutputStream oos = new ObjectOutputStream(bao);
     oos.writeObject(tmp);
     oos.close();
     
     byte[] byteToTransfer = oos.getBytes();*/
 }
}
