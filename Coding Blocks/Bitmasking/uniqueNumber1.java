package codeforces;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n=in.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=in.nextInt();
        }
        int result=0;
        for(int i=0;i<n;i++)
        {
            result^=arr[i];
        }
        out.println(result);
    }
}
