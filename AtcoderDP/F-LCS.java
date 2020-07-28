package AtcoderDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class LCS {

	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		String s = in.next();
		String t = in.next();
		int dp[][] = lcs(s, t);
		int i = s.length();
		int j = t.length();
		StringBuilder sb = new StringBuilder();
		sb.append("");
		while (i > 0 && j > 0) {
			if (s.charAt(i - 1) == t.charAt(j - 1)) {
				sb.append(s.charAt(i - 1));
				i--;
				j--;
			} else {
				if (dp[i - 1][j] > dp[i][j - 1]) {
					i--;
				} else {
					j--;
				}
			}
		}
		sb.reverse();
		System.out.println(sb);
	}

	public static int[][] lcs(String s, String t) {
		int dp[][] = new int[s.length() + 1][t.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}
			}
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp;
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