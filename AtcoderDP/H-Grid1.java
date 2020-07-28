package AtcoderDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Grid1 {
	static int MOD = 1000000007;

	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		int n = in.nextInt();
		int m = in.nextInt();
		char[][] c = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = in.next();
			for (int j = 0; j < m; j++) {
				c[i][j] = s.charAt(j);
			}
		}
		int flag1 = 0;
		int dp[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			if (c[i][0] == '#') {
				flag1 = 1;
			} else {
				if (flag1 == 0)
					dp[i][0] = 1;
				else
					dp[i][0] = 0;
			}
		}
		int flag2 = 0;
		for (int j = 0; j < m; j++) {
			if (c[0][j] == '#') {
				flag2 = 1;
			} else {
				if (flag2 == 0)
					dp[0][j] = 1;
				else
					dp[0][j] = 0;
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {

				dp[i][j] = 0;
				if (c[i - 1][j] != '#') {
					dp[i][j] = (dp[i - 1][j] % MOD);
				}
				if (c[i][j - 1] != '#') {
					dp[i][j] += (dp[i][j - 1] % MOD);
				}
				dp[i][j] = dp[i][j] % MOD;
			}
		}
		if (dp[n - 1][m - 1] != 0) {
			System.out.println(dp[n - 1][m - 1]);
		} else if (dp[n - 1][m - 1] == 0) {
			System.out.println(0);
		}

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