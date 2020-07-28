package contest659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class C {
	static ArrayList<Integer>[] gp;

	@SuppressWarnings({ "unused", "unchecked" })
	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		int T = in.nextInt();
		outer: for (int tt = 0; tt < T; tt++) {
			int n = in.nextInt();
			gp = new ArrayList[20];
			for (int i = 0; i < 20; i++) {
				gp[i] = new ArrayList<Integer>();
			}
			char a[] = in.next().toCharArray();
			char b[] = in.next().toCharArray();
			int flag = 0;
			for (int i = 0; i < n; i++) {
				if (a[i] > b[i]) {
					flag = 1;
					break;
				}
				gp[a[i] - 'a'].add(b[i] - 'a');
				gp[b[i] - 'a'].add(a[i] - 'a');
			}
			if (flag == 1) {
				System.out.println(-1);
				continue;
			}
			boolean visited[] = new boolean[20];
			int ans = 20;
			for (int i = 0; i < 20; i++) {
				if (!visited[i]) {
					dfs(i, visited);
					ans--;
				}
			}
			System.out.println(ans);
		}
	}

	public static void dfs(int u, boolean[] visited) {
		visited[u] = true;
		for (int c : gp[u]) {
			if (!visited[c]) {
				dfs(c, visited);
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