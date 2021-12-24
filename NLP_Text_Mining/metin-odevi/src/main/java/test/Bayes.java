package test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Bayes {

	public void calcBayes(List<String> goal,List<String> sample1,List<String> sample2,List<String>sample3, Set<String> all,String location,String fileName ) throws IOException
	{
		BayesReader reader = new BayesReader();
		System.out.println(goal.toString());
		List<String> results = new ArrayList<String>();
		List<String> precResults = new ArrayList<String>();
		results=reader.read( goal,sample1,sample2,sample3, all,location, fileName);
		double FN=Collections.frequency(results, "0");
		double TP=Collections.frequency(results, "1");
		double recall=TP/(TP+FN);
		System.out.println("Recall= "+recall);
		
		if(fileName!="EkonomiTest")
			precResults.addAll(reader.read( goal,sample1,sample2,sample3, all,"C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\test\\ekonomi", fileName));
		if(fileName!="MagazinTest")
			precResults.addAll(reader.read( goal,sample1,sample2,sample3, all,"C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\test\\magazin", fileName));
		if(fileName!="SaglikTest")
			precResults.addAll(reader.read( goal,sample1,sample2,sample3, all,"C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\test\\saglik", fileName));
		if(fileName!="SporTest")
			precResults.addAll(reader.read( goal,sample1,sample2,sample3, all,"C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\test\\spor", fileName));
		double FP=Collections.frequency(precResults, "1");
		double precision=TP/(TP+FP);
		System.out.println("Precision= "+precision);
		double FScore = 2*(precision*recall)/(precision+recall);
		System.out.println("FScore= "+FScore);
		FileWriter myWriter = new FileWriter(fileName+"fScore"+".txt");
	    myWriter.write(fileName+" Precision= "+precision+"Recall= "+recall+"FScore= "+FScore+"\n");
	    myWriter.close();
	
	
	}
}
