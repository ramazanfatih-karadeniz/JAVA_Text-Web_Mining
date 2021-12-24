package trainset;

import java.io.IOException;

import test.Bayes;

public class NLPApplication {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Training ekonomi=new Training();
		ekonomi.Train("C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\train\\ekonomi","EkonomiTrain");
		
		Training magazin = new Training();
		magazin.Train("C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\train\\magazin","MagazinTrain");
	
		Training saglik = new Training();
		saglik.Train("C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\train\\saglik","SaglikTrain");
	
		Training spor = new Training();
		spor.Train("C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\train\\spor","SporTrain");
		/*
		Training testEkonomi = new Training();
		testEkonomi.Train("C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\test\\ekonomi","EkonomiTest");
		
		Training testMagazin = new Training();
		testMagazin.Train("C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\test\\magazin","MagazinTest");
	
		Training testSaglik = new Training();
		testSaglik.Train("C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\test\\saglik","SaglikTest");
	
		Training testSpor = new Training();
		testSpor.Train("C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\test\\spor","SporTest");
		*/
		Training all= new Training();
		all.Train("C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\AllWords","ALL");
		/*
		Testing testing= new Testing();
		testing.caclFreq("C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\test\\spor", all.getFrequencies(), "SporTest");
		
		Testing testing1= new Testing();
		testing1.caclFreq("C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\train\\spor", all.getFrequencies(), "SporTrain");
		
		Testing testing2= new Testing();
		testing2.caclFreq("C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\train\\saglik", all.getFrequencies(), "SaglikTrain");
		
		Testing testing3= new Testing();
		testing3.caclFreq("C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\train\\magazin", all.getFrequencies(), "MagazinTrain");
		
		Testing testing4= new Testing();
		testing4.caclFreq("C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\train\\ekonomi", all.getFrequencies(), "EkonomiTrain");
	*/
		Bayes bayesEko = new Bayes();
		bayesEko.calcBayes(ekonomi.getRemovedPD(),magazin.getRemovedPD(),saglik.getRemovedPD(),spor.getRemovedPD(), all.getFrequencies(), "C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\test\\ekonomi", "EkonomiTest");

		Bayes bayesMag = new Bayes();
		bayesMag.calcBayes(ekonomi.getRemovedPD(),magazin.getRemovedPD(),saglik.getRemovedPD(),spor.getRemovedPD(), all.getFrequencies(), "C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\test\\magazin", "MagazinTest");

		Bayes bayesSag= new Bayes();
		bayesSag.calcBayes(ekonomi.getRemovedPD(),magazin.getRemovedPD(),saglik.getRemovedPD(),spor.getRemovedPD(), all.getFrequencies(), "C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\test\\saglik", "SaglikTest");

		Bayes bayesSpor = new Bayes();
		bayesSpor.calcBayes(ekonomi.getRemovedPD(),magazin.getRemovedPD(),saglik.getRemovedPD(),spor.getRemovedPD(), all.getFrequencies(), "C:\\Users\\fatih\\OneDrive\\Masaüstü\\metin-madenciligi\\test\\spor", "SporTest");

}}
