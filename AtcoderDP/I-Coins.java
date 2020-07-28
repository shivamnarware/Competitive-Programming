package AtcoderDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Coins {
	static double dp[][] = new double[3001][3001];

	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		int n = in.nextInt();
		double a[] = new double[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = in.nextDouble();
		}
		for (int i = 0; i < 3001; i++) {
			for (int j = 0; j < 3001; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(coins(a, n, (n + 1) / 2));

	}

	public static double coins(double a[], int i, int X) {
		if (X == 0)
			return 1;
		if (i == 0)
			return 0;
		if (dp[i][X] > -0.9)
			return dp[i][X];
		double val = a[i] * (coins(a, i - 1, X - 1)) + (1 - a[i]) * (coins(a, i - 1, X));
		dp[i][X] = val;
		return val;
	}

	static void sort(int[] a) {
		ArrayList<Integer> l = new ArrayList<>();
		for (int i : a)
			l.add(i);
		Collections.sort(l);
		for (int i = 0; i < a.length; i++)
			a[i] = l.get(i);
	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}

}
