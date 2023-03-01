package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY230301_BOJ20922_겹치는건싫어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] cnt = new int[100001];

        int[] input = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int start = 0;
        int end = 0;
        while (end < input.length) {
            while (end < input.length && cnt[input[end]] + 1 <= k) {
                cnt[input[end]]++;
                end++;
            }
            ans = Math.max(ans, end - start);
            cnt[input[start]]--;
            start++;
        }
        System.out.println(ans);
    }
}
