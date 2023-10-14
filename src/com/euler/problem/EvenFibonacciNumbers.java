package com.euler.problem;

import java.util.TreeSet;

public class EvenFibonacciNumbers {
	public static int MAX = 4000000;
	public static TreeSet<Integer> evens = new TreeSet<Integer>();

	public static void main(String[] args) {

		System.out.println(evens.stream().reduce(0, (a,b) -> a+b));
	}

	public static int fibonacci(int a) {

		if (a == 1)
			return 1;
		if (a == 0)
			return 1;

		int result = fibonacci(a - 2) + fibonacci(a - 1);

//		System.out.println("a = " + a + ", result =" + result);

		if (result % 2 == 0)
			evens.add(result);

		return result;
	}

}
