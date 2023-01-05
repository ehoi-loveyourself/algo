package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec22_온도의최댓값_시간초과 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = Integer.MIN_VALUE;
        // n의 범위가 100,000이고
        // k의 범위가 2 <= k <= n 이므로
        // n이 70000이라면 k가 30000정도 돌건데 그렇게만 돌아도 시간초과가 난다.
        // 어떻게 풀어야 할까?
        // 모르니까 공부해야지!
        for (int i = 0; i < n - k; i++) {
            int cnt = 0;
            for (int j = i; j < i + k; j++) {
                cnt += arr[j];
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
}
