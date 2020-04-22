package codeforces;

import FastIO.InputReader;

import java.io.PrintWriter;

public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int x[] = new int[64];
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (arr[i] > 0) {
                int last_bit = (arr[i] & 1);
                x[j] += last_bit;
                j++;
                arr[i] = arr[i] >> 1;
            }
        }
        int ans = 0, p = 1;
        for (int i = 0; i < n; i++) {
           x[i]=x[i]%3;
           ans+=x[i]*p;
           p=p*2;
        }
        out.println(ans);
    }
}
