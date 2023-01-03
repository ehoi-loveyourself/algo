package com.ehoi.algo.bruteforce;

import java.util.*;

public class BOJ14501_퇴사 {
    static int n, ans = 0;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        } // 입력 끝

        work(0, 0);
        System.out.println(ans);
        sc.close();
    }

    private static void work(int day, int income) {
        if (day > n) return;

        if (day == n) {
            ans = Math.max(ans, income);
            return;
        }

        for (int i = day; i < n; i++) {
            // 일을 하고 가고
            work(i + arr[i][0], income + arr[i][1]);
            // 일을 안 하고 가고
            work(i + 1, income);
        }
    }
}
