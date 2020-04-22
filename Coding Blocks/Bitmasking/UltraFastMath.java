package codeforces;

import FastIO.InputReader;

import java.io.PrintWriter;

public class TaskE {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            String str1 = in.next();
            String str2 = in.next();

            String str = "";
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) == str2.charAt(i)) {
                    str += "0";
                } else {
                    str += "1";
                }
            }

            out.println(str);
        }
    }
}
