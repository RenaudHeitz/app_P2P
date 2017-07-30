public class Fichier
{
    String name;
    int fileSize; // octet
    Date uploadDate;
    Date updateDate;
    int id;
    String[] tags;
    int clientId; // Id of the owner
    
    static ArrayList<Fichier> fileList = new ArrayList<Fichier>();
    
    public Fichier(int fileSize, Date uploadDate, Date updateDate , String[] tags, int id, int clientId)
    {
        this.fileSize = fileSize;
        this.uploadDate = uploadDate;
        this.updateDate = updateDate;
        this.tags = tags;
        this.localPath = localPath;
        this.remotePath = remotePath;
        this.clientId = clientId;
    }
    
    public void addFile(Fichier f)
    {
        this.fileList.add(f);
        System.out.println("File added to the list");
    }
    
   /* public void delete(int id)
    {
        
    }*/
    
    public void debugPrintList()
    {
        int i = 0;
        
        while(fileList.get(i) != null)
        {
            System.out.println(i + " " + fileList.get(i).id + " " + fileList.get(i).name);
            i++;
        }
    }
    
    
}
