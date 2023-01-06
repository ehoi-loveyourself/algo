package com.ehoi.algo.bruteforce;

import java.util.Scanner;

public class BOJ10819_차이를최대로 {
    static int n;
    static int[] nums, sel;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n 과 배열 입력받기
        n = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sel = new int[n];
        visited = new boolean[n];

        // 재귀 보내기
        recur(0);

        // 최댓값 출력
        System.out.println(max);
        sc.close();
    }

    private static void recur(int cnt) {
        if (cnt == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(sel[i] - sel[i + 1]);
            }
            max = Math.max(max, sum);
            return;
        }
        // 비중복순열
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            sel[cnt] = nums[i];
            recur(cnt + 1);
            visited[i] = false;
        }
    }
}
