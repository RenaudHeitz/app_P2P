
import java.io.*;
import java.net.*;
import java.util.*;
import java.net.Socket;

public class Main{

 public static void main(String args[]) throws IOException, InterruptedException
 {  
  //String ipServer = "127.0.0.1"; 
  //Client client;
  //client = new Client(ipServer, 5002);
  cFile file = new cFile();
  boolean fnret  = file.scanFolderForNewFiles("library");
  file.debugPrintList();
 }


}
