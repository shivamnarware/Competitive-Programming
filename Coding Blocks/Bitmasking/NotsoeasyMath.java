package codeforces;

import FastIO.InputReader;

import java.io.PrintWriter;

public class TaskF {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int primes[] = {2, 3, 5, 7, 11, 13, 17, 19};
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            long ans=0;
            long subsets = (1 << 8) - 1;
            for (long i = 1; i <= subsets; i++) {
                long demom = 1;
                long setbit = countsetbits(i);
                for (int  j = 0; j <= 7; j++) {
                    if ((i & (1 << j))>0) {
                        demom = demom * primes[j];
                    }
                }
                if((setbit&1)==1)
                {
                    ans+=n/demom;
                }
                else {
                    ans -= n / demom;
                }
            }
            out.println(ans);
        }
    }

    public static long countsetbits(long n) {
        long ans = 0;
        while (n > 0) {
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }
}
