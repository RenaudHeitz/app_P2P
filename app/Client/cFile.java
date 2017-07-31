import java.util.*;
import java.io.File;
import java.util.regex.*;

public class cFile
{
 String name;
 long fileSize; // octet
 Date uploadDate;
 Date updateDate;
 int id;
 int clientId; // Id of the owner
 ArrayList<String> tags;
 String fullPath;
 static ArrayList<cFile> localFileList = new ArrayList<cFile>();
 static ArrayList<cFile> remoteFileList = new ArrayList<cFile>();

 public cFile(String name, long fileSize, Date uploadDate, Date updateDate , ArrayList<String> tags, int id, int clientId, String fullPath)
 {
  this.name = name;
  this.fileSize = fileSize;
  this.uploadDate = uploadDate;
  this.updateDate = updateDate;
  this.tags = tags;
  this.clientId = clientId;
  this.fullPath = fullPath;
 }
 public cFile()
 {

 }
 public void addFile(cFile f)
 {
  //If the clientId equals -1, it is a local file
  if(f.clientId == -1)
  {
   int id = localFileList.size();
   f.id = id;
   localFileList.add(f); 
   System.out.println("File added to the local file list");
  }
  else 
  {
   remoteFileList.add(f);
   System.out.println("File added to the remote file list");
  }
 }

 public ArrayList<cFile> searchByTagsOnLocalFiles(String[] tags)
 {
  int fileListSize = localFileList.size(); 
  ArrayList<cFile> result = new ArrayList<cFile>();

  int tagsSize = tags.length;
  int i, u, v;
  for(i = 0; i < fileListSize; i++)
  {
   for(u = 0; u < tagsSize; u++)
   {
    int fileTagsSize = localFileList.get(i).tags.size();
    for(v = 0; v < fileTagsSize; v++)
    {
     if(this.tags.get(u).equals(localFileList.get(i).tags.get(v)))
     {
      result.add(localFileList.get(i));
     }
    }
   }
  }

  System.out.println("Found " + result.size()  + " corresponding files");
  return result;
 }

 public void debugPrintList()
 {
  int listSize = localFileList.size();

  for(int i = 0; i < listSize; i++) 
  {
   System.out.println(i + " " + localFileList.get(i).id 
     + " " + localFileList.get(i).name);
  }
 }

 public boolean scanFolderForNewFiles(String path)
 {
  //Getting the path of each files
  ArrayList<String> files = recursiveList(path);

  //Store the actual date for later use
  Date actualDate = new Date();
  actualDate.setHours(0);

  /* Regex that match 1: Path, 2: Filename, 3: Extension */
  Pattern p = Pattern.compile("^\\/(.+\\/)*(.+)\\.(.+)$");
  Matcher m;

  for(String file:files)
  {
   System.out.println("Looking for : " + file);
   String tmpFullPath = file;
   String tmpPath = null, filename = null, extension = null;

   //Prepare the regex
   m = p.matcher(tmpFullPath);

   for(int i = 0; i <= m.groupCount(); i++)
   {
    System.out.println(i + " " + m.group(i));
    switch(i)
    {
     case 1: tmpPath = m.group(i); break;
     case 2: filename = m.group(i); break;
     case 3: extension = m.group(i); break;
    }
   }
   //Calculate the filesize
   long fileSize = new File(tmpFullPath).length();

   //Create some random tags
   ArrayList<String> tmpTags= new ArrayList<String>();

   switch(extension)
   {
    case "mp3" : tmpTags.add("music"); break;
    case "jpg" : tmpTags.add("image"); break;
    case "zip" : tmpTags.add("archive"); break;
   }

   //Create the final object
   cFile tmp = new cFile(filename, fileSize, actualDate, actualDate, tmpTags, -1, -1, tmpFullPath);
   //Add it to the file list
   this.addFile(tmp);
  }
  return true;
 }

 private ArrayList<String> recursiveList(String path)
 {
  File root = new File( path );
  File[] list = root.listFiles();

  ArrayList<String> results = new ArrayList<String>();

  if (list == null) return null;

  for ( File f : list ) {
   if ( f.isDirectory() ) {
    //Doing it recursively
    ArrayList<String> tmp = recursiveList( f.getAbsolutePath() );
    for(String el:tmp)
    {
     results.add(el);
    }
   }
   else {
    results.add(f.getAbsolutePath());
   }
  }
  return results;
 }
}
