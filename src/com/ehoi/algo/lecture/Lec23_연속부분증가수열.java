package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec23_연속부분증가수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = 1;
        int len = 1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                len++;
            } else {
                ans = Math.max(ans, len);
                len = 1;
            }
        }
        ans = Math.max(ans, len);
        System.out.println(ans);
    }
}
