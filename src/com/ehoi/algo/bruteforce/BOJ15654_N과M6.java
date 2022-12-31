package com.ehoi.algo.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15654_N과M6 {
    static int n, m;
    static boolean[] visited;
    static int[] nums, ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n, m 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n];
        nums = new int[n];
        ans = new int[m];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        recur(0, 0);
        // 중복 허용 안함
        // 조합을 오름차순으로
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
            if (visited[i]) continue;;
            visited[i] = true;
            ans[cnt] = nums[i];
            recur(i + 1, cnt + 1);
            visited[i] = false;
        }
    }
}