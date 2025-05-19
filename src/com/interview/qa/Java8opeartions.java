package com.interview.qa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Java8opeartions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//programme to find ocuurance of each char in string 
		String st="iloveyouverhsa";

	Map<String, Long>	count=Arrays.stream(st.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	
	System.out.println("count:"+count.toString());
	
	//programme to finf duplicate elments in a string
	
	List<String> duplicateElements=Arrays.stream(st.split("")).collect(Collectors.
			groupingBy(Function.identity(),Collectors.counting())).
	        entrySet().stream().filter(x->x.getValue()>1).
	        map(Map.Entry::getKey).collect(Collectors.toList());
	
	System.out.println("count:"+duplicateElements.toString());
	
	
	//programme to finf unique elments in a string
	
	
	List<String> uniqueElements=Arrays.stream(st.split("")).collect(Collectors.
			groupingBy(Function.identity(),Collectors.counting())).
	        entrySet().stream().filter(x->x.getValue()==1).
	        map(Map.Entry::getKey).collect(Collectors.toList());
	
	System.out.println("count:"+uniqueElements.toString());
	
	
	//find first non repeat element from the string
	
	String firstNonRepeatElements=Arrays.stream(st.split("")).collect(Collectors.
			groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).
	        entrySet().stream().filter(x->x.getValue()==1).findFirst().get().getKey();
	
	System.out.println("count:"+firstNonRepeatElements.toString());
	
	//find first non repeat element from the string
	
		String firstRepeatElements=Arrays.stream(st.split("")).collect(Collectors.
				groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).
		        entrySet().stream().filter(x->x.getValue()>1).findFirst().get().getKey();
		
		System.out.println("count:"+firstRepeatElements.toString());
		
		// Integer Operations
		
		int[] numbers= {4,5,22,7,9,11};
		
		//sort the integers in asending order 
		List<Integer> integerList=Arrays.stream(numbers).boxed().
				sorted().collect(Collectors.toList());
		System.out.println(integerList);
		
		//sort the integers in decending order 
		List<Integer> integerListReverseOrder=Arrays.stream(numbers).boxed().
				sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(integerListReverseOrder);
		
		//find the second highest integer
		Integer seCondHighestNum=Arrays.stream(numbers).boxed().
				sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(seCondHighestNum);
		
		 // String operations
		
		String[] strArray= {"java","techie","papajipapaji","vershaverma","deepakpatkar","cha"};
		
		//find the longest string
		String longestString=Arrays.stream(strArray).reduce((word1, word2)->word1.length()>word2.length() ? word1:word2).get();
		
		System.out.println("longestString:::"+longestString);
		
		
		//find the numbers starts with 1
		
		List<String> numstswith=Arrays.stream(numbers).boxed().map(s->s+"").filter(n->n.startsWith("1")).collect(Collectors.toList());
	    System.out.println(numstswith);
	    
	    
	    //String.join method
	    
	   List<String> nos=Arrays.asList("1","2","3","4");
	    
	   String results= String.join("-", nos);
	   System.out.println(results);
	}

}
