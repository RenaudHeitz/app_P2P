package server;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ServerData extends Thread {
    private final Socket socket;

    //input streams
    DataInputStream streamInput;
    BufferedReader d;
    PrintWriter out;
    
    String content = null;
    public ServerData(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        
        
        
        try {
            
            //in and out stream
            out = new PrintWriter(socket.getOutputStream());
            streamInput = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            d = new BufferedReader(new InputStreamReader(streamInput));
            System.out.println(d.readLine());
  
        }
        catch (IOException ex) {
            Logger.getLogger(ServerData.class.getName()).log(Level.SEVERE, null, ex);
        }   
    } 
}

