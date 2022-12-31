package com.ehoi.algo.bruteforce;

import java.util.*;

public class BOJ15652_N과M4 {
    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        // 중복되어도 됨
        // 하지만 앞선 원소보다는 같거나 커야 함
        recur(1, 0);
        System.out.println(sb);
        sc.close();
    }

    private static void recur(int start, int cnt) {
        if (cnt == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        // recur
        for (int i = start; i <= n; i++) {
            arr[cnt] = i;
            recur(i, cnt + 1);
        }
    }
}
