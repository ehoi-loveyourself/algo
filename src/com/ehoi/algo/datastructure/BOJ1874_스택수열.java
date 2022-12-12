package com.ehoi.algo.datastructure;

import java.io.*;
import java.util.*;

public class BOJ1874_스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = 0;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        out: for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append("+\n");
            while (stack.peek() == arr[k]) {
                stack.pop();
                sb.append("-\n");
                k++;

                if (k == n) break out;
                if (stack.isEmpty()) break;
            }
        }
        if (k != n) bw.write("NO\n");
        else bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
