package com.algorithm.study.dp;

import java.util.ArrayList;

// 동적계획법 -> Topdown 방식의 Memoization 사용하여 구현하기
public class Fibonacci {
		static ArrayList<Integer> fibonacci = new ArrayList<Integer>();
		static ArrayList<Integer> evenFibonacci = new ArrayList<Integer>();

		public static void main (String[] args) {

				fibonacci.add(1);
				fibonacci.add(1);

				for (int i = 2; ; i++) {
						if (fibonacci.get(i-2) + fibonacci.get(i - 1) > 4_000_000) break;
						fibonacci.add(fibonacci.get(i-2) + fibonacci.get(i - 1));
						if (i % 3 == 2) evenFibonacci.add(fibonacci.get(i));
				}
				System.out.println(fibonacci);
				System.out.println(evenFibonacci);

				System.out.println("--- 재귀함수 ---");

				FibonacciRecur.fibo(32);

				System.out.println(FibonacciRecur.fibonacci);
				System.out.println(FibonacciRecur.evenFibonacci);
		}

}
// fibonacci - 피보나치 수열 저장 || evenFibonacci - 피보나치 수열 중 짝수인 수들을 저장

class FibonacciRecur {
		static ArrayList<Integer> fibonacci = new ArrayList<Integer>();
		static ArrayList<Integer> evenFibonacci = new ArrayList<Integer>();

		static int fibo (int n) {

				if (fibonacci.size() > n) return fibonacci.get(n);

				if (n == 0) {
					fibonacci.add(1);
					return 1;
				}

				if (n == 1)  {
						fibonacci.add(1);
						return 1;
				}

//			ArrayList.add (int index, E element) => 메서드로 요소를 집어넣을 때 주의! 만약 빈 리스트에 1이나 2, 즉 인덱스를 벗어나 삽입하려고 하면
//			IndexOutOfBound 에러가 발생. 이전에 다음과 같이 조건식을 썼는데,

				/**
				 * 			if (n == 0) {
				 * 					fibonacci.add(n, 1);
				 * 					return 1;
				 *                }
				 *
				 * 				if (n == 1)  {
				 * 						fibonacci.add(n, 1);
				 * 						return 1;
				 *        }
				 *
				 *        fibo 함수에 홀수를 아규먼트로 넘길 경우, n == 1 이라는 조건에 먼저 도달하기 때문에 indexOutOfBound 에러가 발생한다.
				 */
				if (n % 3 == 2) evenFibonacci.add(fibo(n-2) + fibo(n-1));
				fibonacci.add(n,  fibo(n-2) + fibo(n-1));
				return fibo(n-2) + fibo(n-1);
		} // 짝수 항을 검색할 때 문제가 발생 -> 왜?




}