package codeforces;

import FastIO.InputReader;

import java.io.PrintWriter;

public class TaskG {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String str = in.next();
        int len = str.length();
        long ans = 0;
        ans = (1 << len) - 2;
        int j=0;
        for (int i = len - 1; i >= 0; i--) {
            if (str.charAt(i) == '7') {
                ans += (1 << j);
            }
            j++;
        }
        out.println(ans + 1);
    }
}
