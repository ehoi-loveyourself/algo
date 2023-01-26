package com.ehoi.algo;

import java.io.*;
import java.util.*;

public class DAY230127_BOJ1182_부분수열의합 {
    static int n, s, cnt;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        } // 입력 완료

        recur(0, 0);
        if (s == 0) System.out.println(cnt - 1); // 모든 행을 고르지 않았을 때 sum이 0이 되는 경우 빼기
        else System.out.println(cnt);
        sc.close();
    }

    private static void recur(int idx, int sum) {
        if (idx == n) {
            System.out.println(sum);
            // sum이 s와 같으면 cnt++
            if (sum == s) cnt++;
            return;
        }

        // idx번째를 더하고 가고
        recur(idx + 1, sum + arr[idx]);
        // 안더하고 가고
        recur(idx + 1, sum);
    }
}
