package com.java.practice;

public class Test {
public enum Season {WINTER, SUMMER, AUTUM, FALL}

public static void main(String[] args) {
	for(Season S : Season.values()) {
		System.out.println(S);
	}
}
}
