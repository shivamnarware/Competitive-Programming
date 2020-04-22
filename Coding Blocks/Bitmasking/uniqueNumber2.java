package codeforces;

import FastIO.InputReader;

import java.io.PrintWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= arr[i];
        }
        int pos = 0, temp = result;
        while ((temp & 1) != 1) {
            pos++;
            temp = temp >> 1;
        }
        int mask = (1 << pos);
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & arr[i]) > 0) {
                x ^= arr[i];
            }
        }
//        out.println(x);
        y = x ^ result;
        out.println(Math.min(x, y) + " " + Math.max(x, y));

    }
}
