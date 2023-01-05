package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec22_온도의최댓값_강의 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int ans = sum;

        for (int i = k; i < n; i++) {
            sum = sum + arr[i] - arr[i - k];
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}
