import java.io.File;
import java.io.IOException;

/**
 * Created by owner on 2017/5/13.
 */
public class MainRunner {

    public static void main(String[] args) throws IOException {
        UnZipper unzip = new UnZipper();
        String path = "E:\\TDdownload\\Hentai Manga\\";
        String out = "C:\\Users\\owner\\Documents\\2\\";
        File f = new File(path);

        if(f.exists()){
            if(f.isDirectory()){
                File[] files = f.listFiles();
                if (files != null && files.length > 0) {
                    for (File value : files) {
                        if (value.exists()) {
                            unzip.unZipFiles(value, out);
                        } else
                            System.out.println("File not exists!");
                    }
                }
            }else{
                unzip.unZipFiles(f, out);
            }
        }else{
            System.out.println("File or Directory not exists!");
        }

    }
}
