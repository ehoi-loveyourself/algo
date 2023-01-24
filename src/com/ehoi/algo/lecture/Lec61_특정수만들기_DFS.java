package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec61_특정수만들기_DFS {
    static int n, m, cnt;
    static int[] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        dfs(0, 0);
        // cnt가 0이면 -1 출력, 아니면 cnt 출력
        System.out.println(cnt == 0 ? -1 : cnt);
        sc.close();
    }

    private static void dfs(int num, int sum) {
        // 백트래킹
        if (sum > m) return;
        // 종료 조건
        if (num == n) {
            if (sum == m) cnt++;
            return;
        }
        // 재귀 : 나를 더하거나 빼거나 안 쓰거나
        dfs(num + 1, sum + nums[num]);
        dfs(num + 1, sum - nums[num]);
        dfs(num + 1, sum);
    }
}
