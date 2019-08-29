package com.selenium.paralleltest;
import org.testng.annotations.Test;

public class TestNGParallelTwo {
@Test
public void testone2() {
	System.out.println("This is inside test case one 2" + getClass().getSimpleName() +" with thread id :" + Thread.currentThread().getId());
}
@Test
public void testtwo2() {
	System.out.println("This is inside test case two 2" + getClass().getSimpleName() +" with thread id :" + Thread.currentThread().getId());
}

}
