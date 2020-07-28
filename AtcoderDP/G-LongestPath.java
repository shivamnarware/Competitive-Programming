package AtcoderDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class LongestPath {
	static ArrayList<Integer>[] gp;
	static int dp[];

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		int n = in.nextInt();
		int m = in.nextInt();
		gp = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			gp[i] = new ArrayList<Integer>();
		}
		dp = new int[n + 1];
		Arrays.fill(dp, -1);
		for (int i = 0; i < m; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			gp[x].add(y);
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans = Math.max(ans, dfs(i));
		}
		System.out.println(ans);
	}

	private static int dfs(int src) {

		if (dp[src] != -1)
			return dp[src];
		int bestans = 0;
		int leaf = 1;
		for (int child : gp[src]) {
			leaf = 0;
			bestans = Math.max(bestans, dfs(child));
		}
		if (leaf == 1) {
			dp[src] = 0;
			return 0;
		} else {
			dp[src] = 1 + bestans;
			return 1 + bestans;
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