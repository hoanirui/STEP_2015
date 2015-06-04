import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.*; 
import java.lang.StringBuilder;
import java.lang.Math;
import java.lang.System;
import java.math.BigInteger;

public class LongestWord {
	

	public static void main(String[] args) throws IOException {
		
		String LongestWordFind = "";
		// obtain input string 16 letters		
		String letters;
        Scanner input = new Scanner(System.in);
        System.out.print("Please input 16 letters: ");
        letters = input.nextLine();
       
        LongestWordFind = ReFinding(letters);
        while(LongestWordFind == ""){
        	List<String> reduced = Reduce(letters);
        	for(int t = 0; t < reduced.size(); t++ ){
        		LongestWordFind = ReFinding(reduced.get(t));
        		if(LongestWordFind != ""){
        			break;
        		}
        		 
        	}
        }
	}

	
	
	// Rearrange and find words with the same length
	public static String ReFinding(String letter) throws IOException{
        BigInteger times = factorial(letter.length());
        for(int k = 0; k < times.intValue(); k++ ){
        	Matching(letter);
        	if(Matching(letter) != ""){
        		System.out.print("Longest Word Find:" + letter);
        		return letter;
        	}else{
        		letter = Shuffle(letter);
        	}
        }
        return "";
		
	}
	
	// Search the match word in dictionary
	// using ignore cases for equal
	@SuppressWarnings("resource")
	public static String Matching(String matcher) throws IOException{
		
		FileReader fr = new FileReader("/usr/share/dict/words");
		BufferedReader br = new BufferedReader(fr);
		String s;
		List<String> dict = new ArrayList<String>();
		
		while((s = br.readLine()) != null) {
			dict.add(s);
		}
		fr.close();
		
		for(String st: dict){
			if(matcher.equalsIgnoreCase(st)){
				return matcher;
			}
		}
		return "";//not found
		
		} 

		
	
	// Rearrange a word
	public static String Shuffle(String input){
        List<Character> chars = new ArrayList<Character>();
        for(char c:input.toCharArray()){
            chars.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(chars.size()!=0){
            int randomnum = (int)(Math.random()*chars.size());
            output.append(chars.remove(randomnum));
        }
        //System.out.println(output.toString());
        return output.toString();
    }
		
	
	// reduce one letter from the word given
	// return a list of string that contains all possible reduced wordsa
	public static List<String> Reduce(String wordoff){
		List<Character> chars = new ArrayList<Character>();
		List<String> reducedone = new ArrayList<String>(wordoff.length());
		String wholeword = wordoff;
		for(char c:wordoff.toCharArray()){
            chars.add(c);
        } 
        for(int i = 0; i<wordoff.length(); i++){
        	chars.remove(i);
            StringBuilder wordone = new StringBuilder(wordoff.length());
            for(Character ch: chars)
            {
                wordone.append(ch);
            }
            reducedone.add(wordone.toString());
    		chars.clear();
    		for(char c:wholeword.toCharArray()){
                chars.add(c);
            }
        }
        return reducedone;
		
	}
	
	
	//get the factorial of a given number
	public static BigInteger factorial(int numb){
		BigInteger factValue = BigInteger.ONE;
		for ( int i = 2; i <= numb; i++){
			factValue = factValue.multiply(BigInteger.valueOf(i));
			}	
		return factValue;
		}
}
