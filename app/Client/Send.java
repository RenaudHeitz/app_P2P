
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.net.Socket;

public class Send implements Runnable
{
 private Socket socket; 
 private BufferedReader reader;

 public Send (Socket socket)
 {
  System.out.println("Creation du socket de recepetion");
  this.socket = socket;
 }
 public void run()
 {
  System.out.println("Lancement de la thead de recepetion");
 }
}
