import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;



public class UnZipper extends Thread{

    /**
     *
     * @param zipFile
     * @param descDir
     * @author isea533
     */
    public void unZipFiles(File zipFile, String descDir)throws IOException{
        File pathFile = new File(descDir);
        if(!pathFile.exists()){
            if(!pathFile.mkdirs())
                System.out.println("Path Created failed.");
        }
        System.out.println(zipFile.getPath() + "\\" + zipFile.getName());
        if(!zipFile.isDirectory()){
            System.out.println(zipFile.getName());

            if(zipFile.getName().endsWith(".zip")){
                String folder = zipFile.getName().substring(0, zipFile.getName().lastIndexOf(".zip"));
                ZipFile zip = new ZipFile(zipFile);
                if(!(new File(descDir+folder).isDirectory()) && !(new File(descDir+folder).exists())){
                    for(Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements(); ){
                        ZipEntry entry;
                        entry = entries.nextElement();
                        String zipEntryName = entry.getName();
                        InputStream in = zip.getInputStream(entry);

                        String outPath = (descDir + folder + "\\" + zipEntryName).replaceAll("\\*", "/");//.replaceAll("\\*", "/");

                        File file = new File(outPath.substring(0, outPath.lastIndexOf('\\')));
                        if(!file.exists()){
                            boolean pathCreation = file.mkdirs();
                            if(!pathCreation){
                                System.out.println("Failed to create path " + file);
                            }
                        }

                        if(new File(outPath).isDirectory()){
                            continue;
                        }

                        OutputStream out = new FileOutputStream(outPath);
                        byte[] buf1 = new byte[1024];
                        int len;
                        while((len=in.read(buf1))>0){
                            out.write(buf1,0,len);
                        }
                        in.close();
                        out.close();
                    }
                }
            }
        }else{
            System.out.println(zipFile.isDirectory());
        }
    }

    public void decompressRar(){

    }

}
