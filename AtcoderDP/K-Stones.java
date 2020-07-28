package AtcoderDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Stones {

	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		int n = in.nextInt();
		int k = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int x = Kstone(arr, k);
		if (x == 1) {
			System.out.println("First");
		} else {
			System.out.println("Second");
		}
	}

	public static int Kstone(int a[], int k) {
		int dp[] = new int[k + 1];
		int n = a.length;
		for (int i = 1; i < k + 1; i++) {
			for (int j = 0; j < n; j++) {
				if (i - a[j] >= 0) {
					if (dp[i - a[j]] == 0) {
						dp[i] = 1;
					}
				}
			}
		}
		return dp[k];
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