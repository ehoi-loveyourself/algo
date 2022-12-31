package com.ehoi.algo.bruteforce;

import java.util.*;

public class BOJ15653_N과M5 {
    static int n, m;
    static int[] nums, arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[n];
        arr = new int[m];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        } // 입력 끝
        Arrays.sort(nums);

        recur(0);
        System.out.println(sb);
        sc.close();
    }

    private static void recur(int cnt) {
        if (cnt == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[cnt] = nums[i];
            recur(cnt + 1);
            visited[i] = false;
        }
    }
}
