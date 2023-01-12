package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec39_두배열합치기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        } // 입력 끝

        int k = n + m;
        int[] ans = new int[k];
        int pos_a = 0;
        int pos_b = 0;
        for (int i = 0; i < k; i++) {
            if (pos_a >= n) {
                ans[i] = b[pos_b++];
                continue;
            }
            if (pos_b >= m) {
                ans[i] = a[pos_a++];
                continue;
            }
            if (a[pos_a] <= b[pos_b]) {
                ans[i] = a[pos_a++];
            } else {
                ans[i] = b[pos_b++];
            }
        }

        for (int i : ans) {
            System.out.printf("%d ", i);
        }
        sc.close();
    }
}
