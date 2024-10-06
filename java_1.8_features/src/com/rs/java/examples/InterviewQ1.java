package com.rs.java.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewQ1 {
	
	public static List<Integer> sortedNum(List<Integer> nums){
		return  nums.stream().filter(n -> n % 2 == 0).map(Integer::intValue).collect(Collectors.toList());
	}

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(3, 6, 85, 3, 67, 9, 8, 44, 22, 46, 88, 75, 90);

		int sumOfEvenNumbers = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
		
		System.out.println(sortedNum(numbers));
		System.out.println(sumOfEvenNumbers);
	}

}
