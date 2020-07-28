package AtcoderDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class knapsack2 {
	static long[][] dp;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		FastScanner in = new FastScanner();
//		int T = in.nextInt();
//		outer: for (int tt = 0; tt < T; tt++) {
//		}
		int n = in.nextInt();
		int W = in.nextInt();
		long w[] = new long[n];
		int v[] = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			w[i] = in.nextInt();
			v[i] = in.nextInt();
			sum += v[i];
		}
		dp = new long[n + 1][sum + 1];
		int ans = 0;
		for (int i = sum; i >= 0; i--) {
			if (knapsack(w, v, i, n) <= W) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}

	public static long knapsack(long w[], int v[], int Val, int N) {
		if (Val <= 0)
			return 0;
		if (N <= 0)
			return Integer.MAX_VALUE;
		long ans = 0;
		if (dp[N][Val] > 0)
			return dp[N][Val];
		ans = Math.min(knapsack(w, v, Val, N - 1), w[N - 1] + knapsack(w, v, Val - v[N - 1], N - 1));
		dp[N][Val] = ans;
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
