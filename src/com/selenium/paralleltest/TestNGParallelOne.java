package com.selenium.paralleltest;
import org.testng.annotations.Test;
public class TestNGParallelOne {
	
@Test
public void testone() {
	System.out.println("This is inside Test Case one" + getClass().getSimpleName() + " with thread id : " + Thread.currentThread().getId());
	
}
@Test
public void testtwo() {
	System.out.println("This is inside Test Case two" + getClass().getSimpleName() + " with thread id : " + Thread.currentThread().getId());
	
}
}
