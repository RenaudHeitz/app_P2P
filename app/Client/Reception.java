
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.net.Socket;

public class Reception implements Runnable
{
 private Socket socket; 
 private BufferedReader reader;

 public Reception(Socket socket)
 {
  System.out.println("Socket creation");
  this.socket = socket;
 }
 public void run()
 {
  System.out.println("Thread launching");
 }
}
