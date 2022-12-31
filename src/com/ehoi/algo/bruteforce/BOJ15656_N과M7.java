package com.ehoi.algo.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15656_N과M7 {
    static int n, m;
    static int[] nums, ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[n];
        ans = new int[m];
        // 중복해도 되는 순열
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        recur(0);
        System.out.println(sb);
        sc.close();
    }

    private static void recur(int cnt) {
        if (cnt == m) {
            for (int i : ans) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            ans[cnt] = nums[i];
            recur(cnt + 1);
        }
    }
}
