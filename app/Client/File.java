import java.util.*;

public class File
{
 String name;
 int fileSize; // octet
 Date uploadDate;
 Date updateDate;
 int id;
 String[] tags;
 int clientId; // Id of the owner
 String remotePath;
 String localPath;

 static ArrayList<File> fileList = new ArrayList<File>();

 public File(int fileSize, Date uploadDate, Date updateDate , String[] tags, int id, int clientId)
 {
  this.fileSize = fileSize;
  this.uploadDate = uploadDate;
  this.updateDate = updateDate;
  this.tags = tags;
  this.localPath = localPath;
  this.remotePath = remotePath;
  this.clientId = clientId;
 }

 public void addFile(File f)
 {
  fileList.add(f);
  System.out.println("File added to the list");
 }

 public ArrayList<File> searchByTag(String[] tags)
 {
  int fileListSize = fileList.size(); 
  ArrayList<File> result = new ArrayList<File>();

  int tagsSize = tags.length;
 int i, u, v;
  for(i = 0; i < fileListSize; i++)
  {
   for(u = 0; u < tagsSize; u++)
   {
    int fileTagsSize = fileList.get(i).tags.length;
    for(v = 0; v < fileTagsSize; v++)
    {
     if(this.tags[u].equals(fileList.get(i).tags[v]))
     {
      result.add(fileList.get(i));
     }
    }
   }
  }

  System.out.println("Found " + result.size()  + " corresponding files");
  return result;
 }
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
