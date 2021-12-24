package trainset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextReader {

	public String readText(String newFile, String format,String space) throws IOException
	{
		File dir = new File(newFile);
		File[] files = dir.listFiles();
		String sentences="";
		
        for (File file : files) {
            if(file.isFile()) {
                BufferedReader inputStream =new BufferedReader(new InputStreamReader(new FileInputStream(file),format));
                String line;
                try {
                    
                    while ((line = inputStream.readLine()) != null) {
                        sentences+= space+ line;
                    }
                }catch(IOException e) {
                	System.out.println(e);
                }
                finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
        }
        return sentences;
	}
}
