package trainset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TextReader {

	public List<String> readText(String newFile, String format,String space) throws IOException
	{
		Random rand = new Random();
		File dir = new File(newFile);
		File[] files = dir.listFiles();
		List<String> sentences=new ArrayList<String>();
		String sentence="";
		Set<String> randTxtFiles = new HashSet<>();
        for (File file : files) {

        	System.out.println(file.getName());
        	
            if(file.isFile()) {
                BufferedReader inputStream =new BufferedReader(new InputStreamReader(new FileInputStream(file),format));
                String line;
                try {
                    
                    while ((line = inputStream.readLine()) != null) {
                        sentence+= space+ line;
                    sentences.add(sentence);
                    sentence="";
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
