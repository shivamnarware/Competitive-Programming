package AtcoderDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Vacation {
	static int[][] dp;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		FastScanner in = new FastScanner();
//		int T = in.nextInt();
//		outer: for (int tt = 0; tt < T; tt++) {
//		}
		int n = in.nextInt();
		int a[][] = new int[n][3];
		dp = new int[n][3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				a[i][j] = in.nextInt();
				dp[i][j] = -1;
			}
		}
		int ans = 0;
		for (int i = 0; i < 3; i++) {
			ans = Math.max(ans, hapiness(a, n - 1, i));
		}
		System.out.println(ans);

	}

	public static int hapiness(int a[][], int i, int j) {
		if (i == 0) {
			if (j == 0) {
				return Math.max(a[0][j + 1], a[0][j + 2]);
			}
			if (j == 1) {
				return Math.max(a[0][j - 1], a[0][j + 1]);
			}
			if (j == 2) {
				return Math.max(a[0][j - 2], a[0][j - 1]);
			}
		}
		if (dp[i][j] != -1)
			return dp[i][j];
		int ans1 = 0, ans2 = 0, ans3 = 0;
		if (j == 0) {
			ans1 = a[i][j] + Math.max(hapiness(a, i - 1, j + 1), hapiness(a, i - 1, j + 2));
		}
		if (j == 1) {
			ans2 = a[i][j] + Math.max(hapiness(a, i - 1, j - 1), hapiness(a, i - 1, j + 1));
		}
		if (j == 2) {
			ans3 = a[i][j] + Math.max(hapiness(a, i - 1, j - 2), hapiness(a, i - 1, j - 1));
		}
		int ans = Math.max(ans1, Math.max(ans2, ans3));
		dp[i][j] = ans;
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
