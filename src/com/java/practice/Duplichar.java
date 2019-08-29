package com.java.practice;

import java.util.Scanner;

public class Duplichar{
	public static int MAX_CHAR = 256;

	public static void getrepeatchar(String str) {
		int count[] = new int[MAX_CHAR];
		int len = str.length();
		for(int i=0; i< len;i++) {
			count[str.charAt(i)]++;
			}
		char[] ch = new char[str.length()];
		for(int i=0;i<len;i++ ) {
			ch[i] = str.charAt(i);
			int find=0;
			for(int j=0;j<=i;j++) {
				if(str.charAt(i)==ch[j]) {
					find++;
					
				}
				if(find==1) {
					System.out.println("The number of occurence of " + "\"" + str.charAt(i) + "\"" + " is " + count[str.charAt(i)]);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("Enter the characters [ a to z or A to Z] any word : ");
		Scanner sc = new Scanner(System.in);
		String str =sc.next();
		int cn = 0;
		char[] inp = str.toCharArray();
		System.out.println("Duplicate characters are : ");
	for(int i=0;i<=str.length();i++) {
		for(int j=i+1; j< str.length();j++) {
			if(inp[i]==inp[j]) {
				System.out.println(inp[j]);
				cn++;
				break;
			}
			
		}
	}
	getrepeatchar(str);
	}
	
}