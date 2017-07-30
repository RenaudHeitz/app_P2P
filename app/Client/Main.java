
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
 ArrayList<String> tmp = file.recursiveList("./library");
 for(String el:tmp)
 {
  System.out.println(el);
 }
 }


}
