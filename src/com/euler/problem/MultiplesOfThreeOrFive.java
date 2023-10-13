package com.euler.problem;

import java.util.Scanner;

public class MultiplesOfThreeOrFive {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("입력 >> ");

		int input = scanner.nextInt();

		System.out.println(findThreeOrFiveAndSum(0, input));

	}

	public static int findThreeOrFiveAndSum(int x, int max) {
		if (x >= max)
			return 0;

		if (x % 3 == 0 || x % 5 == 0)
			return x + findThreeOrFiveAndSum(x + 1, max);

		return findThreeOrFiveAndSum(x + 1, max);
	}
}
