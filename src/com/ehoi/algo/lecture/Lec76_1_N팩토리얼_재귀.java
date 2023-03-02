package com.ehoi.algo.lecture;

import java.util.Arrays;
import java.util.Scanner;

public class Lec76_1_N팩토리얼_재귀 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(factorial(n));

        sc.close();
    }

    private static int factorial(int n) {
        if (dp[n] != -1) return dp[n];

        if (n == 1) return dp[n] = 1;

        return dp[n] = n * factorial(n - 1);
    }
}
