package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY230301_BOJ2003_수들의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int ans = 0;

        while (start < arr.length) {
            while (end < arr.length && sum < m) {
                sum += arr[end];
                end++;
                if (sum == m) ans++;
            }
            // 같거나 넘쳐버리면 빼줘야해
            sum -= arr[start];
            start++;
            if (sum == m) ans++;
        }
        System.out.println(ans);
    }
}
