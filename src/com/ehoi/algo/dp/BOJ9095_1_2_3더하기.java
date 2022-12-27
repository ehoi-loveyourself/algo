package com.ehoi.algo.dp;

import java.util.*;

public class BOJ9095_1_2_3더하기 {
    static int[] dp = new int[12];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Arrays.fill(dp, -1);

        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            System.out.println(dp(sc.nextInt()));
        }
    }

    private static int dp(int num) {
        if (dp[num] != -1) return dp[num];

        // 초기값 설정
        if (num == 1 || num == 2) {
            return dp[num] = num;
        }
        if (num == 3) {
            return dp[num] = 4;
        }

        return dp[num] = dp(num - 1) + dp(num - 2) + dp(num - 3);
    }
}
