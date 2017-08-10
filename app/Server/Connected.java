

import java.net.Socket;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Renaud
 */
public class Connected {
    
    private Socket socket;
    public static ArrayList<Connected> connectedList = new ArrayList<Connected>();
    
    public Connected(Socket s)
    {
        this.socket =s ;
    }
    
    public void add(Connected C)
    {
        connectedList.add(C);
    }
    public void delete()
    {
        connectedList.remove(this);
    }
    
    
}
