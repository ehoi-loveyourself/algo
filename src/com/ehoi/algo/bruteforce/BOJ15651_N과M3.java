package com.ehoi.algo.bruteforce;

import java.util.*;

public class BOJ15651_N과M3 {
    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // N과 M 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        // visited 배열은 필요 없음
        arr = new int[m];
        // 순서대로 전부 담으면 됨
        recur(0);
        System.out.println(sb);
        sc.close();
    }

    private static void recur(int cnt) {
        // base : cnt가 m과 같다면
        if (cnt == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        // recur
        for (int i = 0; i < n; i++) {
            arr[cnt] = i + 1;
            recur(cnt + 1);
        }
    }
}
