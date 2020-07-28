package contest659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		int T = in.nextInt();
		outer: for (int tt = 0; tt < T; tt++) {
			int n = in.nextInt();
			int a[] = in.readArray(n);
			String s = "";
			for (int i = 0; i < 50; i++) {
				s += 'a';
			}
			System.out.println(s);
			char c[] = s.toCharArray();
			for (int i = 0; i < n; i++) {
				if (c[a[i]] == 'z')
					c[a[i]] = 'a';
				else
					c[a[i]]++;
				String str = new String(c);
				System.out.println(str);
			}
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