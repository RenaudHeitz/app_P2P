import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.ArrayList;


public class Reception implements Runnable
{
    
    private final Socket socket;
    private  BufferedReader in;
    private String message = null;
    private  DataInputStream streamInput;
    private  PrintWriter out;
    
    public Reception(Socket s)
    {
        System.out.println("Creation of the reception socket");
        this.socket = s;
        
    }
    
    public void run()
    {
                    System.out.println("Reception thread launching");
        
            try
            {
                // Reception of the client's file list
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                    ArrayList<cFile> s = (ArrayList<cFile>)ois.readObject();

                System.out.println("File list received from " + socket.getInetAddress());
             
                cFile.localFileList.addAll(s);
                System.out.println("Files added to the local list");
             
              
                
                
                // Reception of the client's messages, used to download or search file
                
                out = new PrintWriter(socket.getOutputStream());
                streamInput = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                
                in = new BufferedReader(new InputStreamReader(streamInput));
                
                boolean run = false;
                while(run==false)
                {
            
                        // message contains what instruction the client send
                        
                        message = in.readLine();
                        System.out.println(socket.getInetAddress() +" : "+message);
                      
                        // if the user want to search a file
                        if(message.contains("/search"))
                        {
                            String stringTag = message.substring(8); // Get the tag out of the message
                            String[] tabTag = stringTag.split(",");
                            ArrayList<cFile> result = cFile.searchByTagsOnLocalFiles(tabTag);
                            out.println("The result of your search are : ");
                            for(int i = 0 ; i < result.size(); i++)
                            {
                                out.println("Id : " +result.get(i).getId()+ " Name : " + result.get(i).getName());
                                out.println("If you want to download this file, please type \"/download \" followed by the id of the file, here : " + result.get(i).getId() );
                                out.flush();
                            }
                            

                        }
                    
                        if(message.contains("/download"))
                        {
                            String stringInfo = message.substring(9); // Get the informations out of the message
                            String[] tabInfo = stringInfo.split(" ");
                            int idToDownload = Integer.parseInt(tabInfo[1]);
                            int listeningPort = Integer.parseInt(tabInfo[2]);
                            cFile fileToDownload = cFile.localFileList.get(idToDownload);
                            int idOfTheOwner = fileToDownload.getOwnerId();
                            
                            // Initialisation of the stream to send message to the owner of the file
                            
                            out2 = new PrintWriter((Connected.connectedList.get(idOfTheOwner)).getOutputStream());

                            out2.println("Someone is requesting the file " + idToDownload);
                            out2.flush();
                            
                        }
                        
                    
                    /*
                        
                        // si un utilisateur souhaite se déconnecter
                        if(message.compareToIgnoreCase("/deco")==0)
                        {
                            System.out.println("L'utilisateur " + co.getName()+" tente de se déconnecter ");
                            out.println("Déconnexion accordé");
                            out.flush();
                            run = true;
                            
                            for(int i =0; i < listeClient.size();i++)
                            {
                                if(listeClient.get(i)!=this.out)
                                {
                                    listeClient.get(i).println("L'utilisateur " + co.getName()+" vient de se déconnecter ");
                                    listeClient.get(i).flush();
                                }
                            }
                            in.close();
                            out.close();
                            socket.close();
                            
                        }*/
                        
                   
                }
            }
            catch(IOException ioe)
            {
                System.out.println("Erreur : " + ioe.getMessage());
            }
            catch(ClassNotFoundException cnfe)
            {
                System.out.println("Serveur non trouvé" + cnfe.getMessage());
            }
          
        
    }
    
    
}
