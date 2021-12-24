package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestReader {

	public List<String> read(String location,Set<String> freq,String fileName) throws IOException
	{
		File dir = new File(location);
		File[] files = dir.listFiles();
		String sentences="";
		TF tf = new TF();
		List<String> rValue = new ArrayList<String>();
        for (File file : files) {
            if(file.isFile()) {
                BufferedReader inputStream =new BufferedReader(new InputStreamReader(new FileInputStream(file),"ISO-8859-9"));
                String line;
                try {
                    
                    while ((line = inputStream.readLine()) != null) {
                    	sentences+=line;
                    	
                    }
                    rValue.add(file.getName());
                    rValue.addAll(tf.calculateTf(sentences,freq));
                   	rValue.add(fileName);
                   	sentences="";
                   	FileWriter myWriter = new FileWriter("deneme"+fileName+"Test"+".txt");
        		    myWriter.write(rValue.toString());
        		    myWriter.close();
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
        
        return rValue;  
	}
}
