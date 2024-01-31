import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Main {
	
	public static TreeMap<String, Integer> unigramStringCount = new TreeMap<>();
	public static TreeMap<String, Integer> bigramStringCount = new TreeMap<>();
	public static TreeMap<String, Integer> trigramStringCount = new TreeMap<>();
	public static TreeMap<String, Double> unigramProbability = new TreeMap<>();
	public static TreeMap<String, Double> bigramProbability = new TreeMap<>();
	public static TreeMap<String, Double> trigramProbability = new TreeMap<>();
	
	public static String readTxt(String txtName) {

		String txt = "";

		try  
		{  
			//the file to be opened for reading  
			FileInputStream fis=new FileInputStream(txtName);       
			Scanner sc=new Scanner(fis);    //file to be scanned  
			//returns true if there is another line to read  
			while(sc.hasNextLine())  
			{  
				//System.out.println();      //returns the line that was skipped  
				txt += sc.nextLine() +"\n";
			}  
			sc.close();     //closes the scanner  
		}  
		catch(IOException e)  
		{  
			e.printStackTrace();  
		} 
		
		
		String regex = "[\\p{Punct}]";

        // Remove punctuation symbols using replaceAll
        txt = txt.replaceAll(regex, "");
        
        txt = txt.replaceAll(" \n", " ");
        txt = txt.replaceAll("\\d"," ");
        txt = txt.replaceAll("[\r\n]+", "\n");
        txt = txt.replaceAll("\n", " ");
        txt = txt.replaceAll("\t", " ");
        txt = txt.replaceAll(" +", " ");
        
        txt = txt.toLowerCase();
		return txt;

	}
	
	public static void calculate_ngram_counts_probabilities(String txt) {
		String[] splittedTxtArray = txt.split(" ");
		
		List<String> splittedTxtArrayList = new ArrayList<String>(Arrays.asList(splittedTxtArray));//(ArrayList<String>) Arrays.asList(splittedTxtArray);
		
		splittedTxtArrayList.remove("");
		splittedTxtArrayList.remove(" ");
		splittedTxtArrayList.remove("	");
		
		// Calculating the count of words and word groups
		for (int i = 0; i < splittedTxtArrayList.size(); i++) {

			//Calculating the count of single words
			unigramStringCount.put(splittedTxtArrayList.get(i),(unigramStringCount.get(splittedTxtArrayList.get(i)) == null) ? 1: unigramStringCount.get(splittedTxtArrayList.get(i)) + 1);
			
			//Calculating the count of binary phrases
			if (i<splittedTxtArrayList.size()-1) {
				
				String bigramSlice = splittedTxtArrayList.get(i) + " " + splittedTxtArrayList.get(i+1);
				bigramStringCount.put(bigramSlice,(bigramStringCount.get(bigramSlice) == null) ? 1: bigramStringCount.get(bigramSlice) + 1);
			}
			
			//Calculating the count of triple phrases
			if (i<splittedTxtArrayList.size()-2) {
				
				String str3 = splittedTxtArrayList.get(i+2).trim();
				String trigramSlice = splittedTxtArrayList.get(i) + " " + splittedTxtArrayList.get(i+1)+ " " + splittedTxtArrayList.get(i+2);
				trigramStringCount.put(trigramSlice,(trigramStringCount.get(trigramSlice) == null) ? 1: trigramStringCount.get(trigramSlice) + 1);
			}
			
		}
		
		//Calculating n-gram probabilities
		for (int i = 0; i < splittedTxtArrayList.size(); i++) {
			
			// uni-gram probabilities
			if(unigramProbability.get(splittedTxtArrayList.get(i)) == null){
				unigramProbability.put(splittedTxtArrayList.get(i), unigramStringCount.get(splittedTxtArrayList.get(i))/(double)splittedTxtArrayList.size());
			}
			
			// bi-gram probabilities
			if (i<splittedTxtArrayList.size()-1) {
				
				String bigramSlice = splittedTxtArrayList.get(i) + " " + splittedTxtArrayList.get(i+1);
				if(bigramProbability.get(bigramSlice) == null){
					bigramProbability.put(bigramSlice, bigramStringCount.get(bigramSlice)/(double)unigramStringCount.get(splittedTxtArrayList.get(i)));
				}
			}
			
			// tri-gram probabilities
			if (i<splittedTxtArrayList.size()-2) {
				
				
				String trigramSlice = splittedTxtArrayList.get(i) + " " + splittedTxtArrayList.get(i+1)+ " " + splittedTxtArrayList.get(i+2);
				if(trigramProbability.get(trigramSlice) == null){
					trigramProbability.put(trigramSlice, trigramStringCount.get(trigramSlice)/(double)bigramStringCount.get(splittedTxtArrayList.get(i)+" "+splittedTxtArrayList.get(i+1)));
				}
			}
		}
		
	}
	
	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
    Comparator<K> valueComparator = new Comparator<K>() {
    	
	      public int compare(K k1, K k2) {
	        int compare = map.get(k2).compareTo(map.get(k1));
	              
	        if (compare == 0) 
	          return 1;
	        else 
	          return compare;
	      }
    };
 
    Map<K, V> sortedByValues = 
      new TreeMap<K, V>(valueComparator);
    sortedByValues.putAll(map);
    return sortedByValues;
  }
	
	public static <K, V> void printTopItems(Map<K, V> newMap, int topCount) {
	    int k = 0;

	    for (Map.Entry<K, V> entry : newMap.entrySet()) {
	    	
	    	if(entry.getValue() instanceof Double) {
	    		System.out.printf("%d- %s ==> %.5g%n", (k + 1), entry.getKey(), entry.getValue());
	    	}else {
	    		System.out.println((k + 1) + "- " + entry.getKey() + " ==> " + entry.getValue() );
	    	}
	        
	    	
	        k++;

	        if (k == topCount) {
	            break;
	        }
	    }
	}
	
	public static void ngramProcess(String txtName) {
		long start = System.currentTimeMillis();
		
		String txt1 = readTxt(txtName);
		
		calculate_ngram_counts_probabilities(txt1);
		
		//unigram
		System.out.println("\n********************************************************");
		System.out.println("top 20 unigram count\n");
		
		TreeMap<String, Integer> sortedUnigramCountMap = (TreeMap<String, Integer>) sortByValues(unigramStringCount);
		
		printTopItems(sortedUnigramCountMap,20);
		
		System.out.println("\n********************************************************");
		System.out.println("top 20 unigram probabilities\n");
		
		TreeMap<String, Double> sortedUnigramProbabilityMap = (TreeMap<String, Double>) sortByValues(unigramProbability);
		
		printTopItems(sortedUnigramProbabilityMap,20);
		
		//bigram
		System.out.println("\n********************************************************");
		System.out.println("top 20 bigram count\n");
		
		TreeMap<String, Integer> sortedBigramCountMap = (TreeMap<String, Integer>) sortByValues(bigramStringCount);
		
		printTopItems(sortedBigramCountMap,20);
		
		System.out.println("\n********************************************************");
		System.out.println("top 20 bigram probabilities\n");
		
		TreeMap<String, Double> sortedBigramProbabilityMap = (TreeMap<String, Double>) sortByValues(bigramProbability);
		
		printTopItems(sortedBigramProbabilityMap,20);
		
		//trigram
		System.out.println("\n********************************************************");
		System.out.println("top 20 trigram count\n");
		
		TreeMap<String, Integer> sortedTrigramCountMap = (TreeMap<String, Integer>) sortByValues(trigramStringCount);
		
		printTopItems(sortedTrigramCountMap,20);
		
		System.out.println("\n********************************************************");
		System.out.println("top 20 trigram probabilities\n");
		
		TreeMap<String, Double> sortedTrigramProbabilityMap = (TreeMap<String, Double>) sortByValues(trigramProbability);
		
		printTopItems(sortedTrigramProbabilityMap,20);
		
		long finish = System.currentTimeMillis();
		
		long timeElapsed = finish - start;
		System.out.println("\nThe ngram probability calculation of the "+ txtName +" took "+timeElapsed+" millisecond.");
		
		System.out.println("\n********************************************************\n********************************************************\n\n");
		
		unigramStringCount.clear();
		bigramStringCount.clear();
		trigramStringCount.clear();
		unigramProbability.clear();
		bigramProbability.clear();
		trigramProbability.clear();
		
	}

	public static void main(String[] args) {
		
		ngramProcess("BÝLÝM ÝÞ BAÞINDA.txt") ;
		ngramProcess("BOZKIRDA.txt") ;
		ngramProcess("DEÐÝÞÝM.txt") ;
		ngramProcess("DENEMELER.txt") ;
		ngramProcess("grimms-fairy-tales_P1.txt") ;

	}

}
