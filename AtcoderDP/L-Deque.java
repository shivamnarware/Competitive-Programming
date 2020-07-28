package AtcoderDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Deque {
	static long dp[][][] = new long[3001][3001][2];

	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		int n = in.nextInt();
		int a[] = in.readArray(n);
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
		}
		long ans = deque(a, 0, n - 1, 0);
		long finalans = 2 * ans - sum;
		System.out.println(finalans);
	}

	public static long deque(int a[], int i, int j, int turn) {
		if (i > j)
			return 0;

		if (dp[i][j][turn] > 0)
			return dp[i][j][turn];

		if (turn == 0) {
			long ans = Math.max(a[i] + deque(a, i + 1, j, 1), a[j] + deque(a, i, j - 1, 1));
			dp[i][j][turn] = ans;
			return ans;
		} else {
			long ans = Math.min(deque(a, i + 1, j, 0), deque(a, i, j - 1, 0));
			dp[i][j][turn] = ans;
			return ans;
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