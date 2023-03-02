package com.ehoi.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lec76_이항계수_메모이제이션 {
    static int[][] dp = new int[21][21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        System.out.println(dfs(n, r));
    }

    private static int dfs(int n, int r) {
        if (dp[n][r] > 0) return dp[n][r];
        if (r == 1) return dp[n][r] = n;
        if (n == r) return dp[n][r] = 1;

        return dp[n][r] = dfs(n - 1, r - 1) + dfs (n - 1, r);
    }
}
