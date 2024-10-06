package com.rs.java.examples;

public class InterviewQ3 {

	public static void main(String[] args) {

		// Input:4 3 1
		// 9 0 7
		// 5 6 2
		int[][] matrix2 = new int[3][3];
		int[][] matrix = { { 4, 3, 1 }, { 9, 0, 7 }, { 5, 6, 2 } };

		for (int j = 0; j < 3; j++) {

			for (int i = 0; i < 3; i++) {
				matrix[i][j] += matrix2[j][i];
			}
		}

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {

				System.out.print(matrix2[i][j]);
			}
		}
	}

}
