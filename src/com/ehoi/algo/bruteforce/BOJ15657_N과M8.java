package com.ehoi.algo.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15657_N과M8 {
    static int n, m;
    static int[] nums, ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        // 중복 조합
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[n];
        ans = new int[m];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        recur(0, 0);
        System.out.println(sb);
        sc.close();
    }

    private static void recur(int start, int cnt) {
        if (cnt == m) {
            for (int i : ans) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            ans[cnt] = nums[i];
            recur(i, cnt + 1);
        }
    }
}
