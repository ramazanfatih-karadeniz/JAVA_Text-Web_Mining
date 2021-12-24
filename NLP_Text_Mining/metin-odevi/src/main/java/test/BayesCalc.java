package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BayesCalc {
	
	public String finalCalc(List<String> tokens,List<String> goal,List<String> sample1,List<String> sample2,List<String>sample3, Set<String> all)
	{
		List<Double> probs = new ArrayList<Double>();
		List<String> allWords= new ArrayList<String>();
		allWords.addAll(sample1);
		allWords.addAll(sample2);
		allWords.addAll(sample3);
		Set<String> tokenf = new HashSet<>(tokens);
		Double pay,payda;
		pay=payda=0.0;
		for (String word : tokenf)
		{
			
			pay= (double) Collections.frequency(goal, word)+1;
			payda = (double) all.size() + (double)goal.size();
			if(pay!=1)
			//System.out.println(pay +" -- " + payda);
			probs.add(pay/payda);
		}
		Double ansPlus= 0.25;
		for (Double a : probs)
		{
			//System.out.println(a);
			ansPlus*=a;
		}
		probs.clear();
		for (String word : tokenf)
		{
			
			pay= (double) Collections.frequency(allWords, word)+1;
			payda = (double) all.size() + (double)allWords.size();
			if(pay!=1)
			//System.out.println(pay +" -- " + payda);
			probs.add(pay/payda);
		}
		Double ansMines= 0.25;
		for (Double a : probs)
		{
			//System.out.println(a);
			ansMines*=a;
		}
		
		if(ansPlus > ansMines)
			return "1";
		else
			return "0";
	}
}
