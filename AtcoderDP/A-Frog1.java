package AtcoderDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Frog1 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		FastScanner in = new FastScanner();
//		int T = in.nextInt();
//		outer: for (int tt = 0; tt < T; tt++) {
//		}
		int n = in.nextInt();
		int a[] = in.readArray(n);
		int dp[] = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(frog1(dp, a, n - 1));
	}

	public static int frog1(int dp[], int a[], int N) {
		if (N == 0)
			return 0;

		if (dp[N] != -1)
			return dp[N];
		int ans = 0, ans1 = Integer.MAX_VALUE, ans2 = Integer.MAX_VALUE;
		if (N - 1 >= 0) {
			ans1 = (Math.abs(a[N] - a[N - 1]) + frog1(dp, a, N - 1));
		}
		if (N - 2 >= 0) {
			ans2 = (Math.abs(a[N] - a[N - 2]) + frog1(dp, a, N - 2));
		}
		ans = Math.min(ans1, ans2);
		dp[N] = ans;
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