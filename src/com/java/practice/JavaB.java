package com.java.practice;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JavaB {
public static void main(String[] args) {
	Map<String, Integer> mp = new HashMap<String, Integer>();
	mp.clear();
	mp.put("A", 1);
	mp.put("B", 2);
	
	for(Map.Entry<String, Integer> entry : mp.entrySet()) {
		System.out.println("Item : " + entry.getKey() +" "+ "Count : " + entry.getValue());
		
	     String blogName = "howtodoinjava.com";
	        System.out.println(blogName.substring(3));  //todoinjava.com
	         
	        System.out.println("hello world".substring(6));//Substring using single index
	        System.out.println("hello world".substring(6,10));//Substring using start and end index
	        //Unsorted array
	        Integer[] numbers = new Integer[] { 15, 11, 9, 55, 47, 18, 520, 1123, 366, 420 };
	        
	      //Sort the array in reverse order
	      Arrays.sort(numbers, Collections.reverseOrder());
	       
	      //Print array to confirm
	      System.out.println(Arrays.toString(numbers));
	}
}
}
