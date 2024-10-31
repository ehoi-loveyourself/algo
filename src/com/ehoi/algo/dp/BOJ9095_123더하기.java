package com.ehoi.algo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9095_123더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[11]; // 11보다 작은 숫자가 들어오니까 길이를 11로 설정
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int n = 4; n < 11; n++) {
            dp[n] = dp[n - 1] + dp[n - 2] + dp[n - 3];
        }

        StringBuffer sb = new StringBuffer();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}