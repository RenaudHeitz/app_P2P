public class Fichier
{
    String name;
    int fileSize; // octet
    Date uploadDate;
    Date updateDate;
    int id;
    String[] tags;
    String localPath;
    String remotePath;
    
    public Fichier(int fileSize, Date uploadDate, Date updateDate , String[] tags, int id, String localPath, String remotePath)
    {
        fileSize = fileSize;
        uploadDate = uploadDate;
        updateDate = updateDate;
        tags = tags;
    }
}
