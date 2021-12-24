package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import trainset.PunctuationAndDigits;
import zemberek.tokenization.TurkishTokenizer;

public class BayesReader {
	
	public List<String> read(List<String> goal,List<String> sample1,List<String> sample2,List<String>sample3, Set<String> all,String location,String fileName) throws IOException
	{
		File dir = new File(location);
		File[] files = dir.listFiles();
		String sentences="";
		List<String> rValue = new ArrayList<String>();
        for (File file : files) {
            if(file.isFile()) {
                BufferedReader inputStream =new BufferedReader(new InputStreamReader(new FileInputStream(file),"ISO-8859-9"));
                String line;
                try {
                    
                    while ((line = inputStream.readLine()) != null) {
                    	sentences+=line;
                    
                    }	
                    TurkishTokenizer tokenizer = TurkishTokenizer.DEFAULT;
                	    List<String> tokens = tokenizer.tokenizeToStrings(sentences);
                	    PunctuationAndDigits pD= new PunctuationAndDigits();
                	    List<String> removedPD = pD.removePD(tokens);
                	    BayesCalc calc = new BayesCalc();
                	    rValue.add(calc.finalCalc(removedPD, goal,sample1,sample2,sample3, all));
                	    sentences="";
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
