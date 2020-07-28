package AtcoderDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class knapsack1 {
	static long[][] dp;

	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		int n = in.nextInt();
		int W = in.nextInt();
		int w[] = new int[n];
		long v[] = new long[n];
		dp = new long[W + 1][n + 1];
		for (int i = 0; i < n; i++) {
			w[i] = in.nextInt();
			v[i] = in.nextInt();
		}
		System.out.println(knapsack(w, v, W, n));
	}

	public static long knapsack(int w[], long v[], int W, int N) {
		if (N == 0)
			return 0;
		if (dp[W][N] > 0)
			return dp[W][N];
		long ans = 0;
		if (w[N - 1] <= W) {
			ans = Math.max(knapsack(w, v, W, N - 1), v[N - 1] + knapsack(w, v, W - w[N - 1], N - 1));
		} else {
			ans = Math.max(ans, knapsack(w, v, W, N - 1));
		}
		dp[W][N] = ans;
		return ans;
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
	}

}
