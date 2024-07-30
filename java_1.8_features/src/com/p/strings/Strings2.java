/*
 * import java.util.*; import java.io.*; import java.lang.Math;
 * 
 * public class Strings2 { public static int MaxOdd(int N, int[] A, int K) { int
 * result = -404;
 * 
 * int findMaxOdd(int[] array) { int maxOdd = Integer.MIN_VALUE; for (int i = 1;
 * i < array.length; i += 2) { if (array[i] > maxOdd) { maxOdd = array[i]; } }
 * return maxOdd; }
 * 
 * result = findMaxOdd(A);
 * 
 * for (int i = 0; i < K; i++) { int temp = A[0]; for (int j = 0; j < N - 1;
 * j++) { A[j] = A[j + 1]; } A[N - 1] = temp;
 * 
 * int currentMaxOdd = findMaxOdd(A); if (currentMaxOdd > result) { result =
 * currentMaxOdd; } }
 * 
 * return result; }
 * 
 * public static void main(String[] args) { Scanner sc = new Scanner(System.in);
 * 
 * int N = sc.nextInt(); int[] A = new int[N]; for (int i = 0; i < N; i++) {
 * A[i] = sc.nextInt(); } int K = sc.nextInt();
 * 
 * sc.close();
 * 
 * int result = MaxOdd(N, A, K); System.out.println(result);     } }
 */