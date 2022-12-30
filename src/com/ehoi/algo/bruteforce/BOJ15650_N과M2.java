package com.ehoi.algo.bruteforce;

import java.util.*;

public class BOJ15650_N과M2 {
    static int N, M;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N];
        arr = new int[M];

        recur(0, 0);

        System.out.println(sb);
        sc.close();
    }

    private static void recur(int start, int cnt) {
        if (cnt == M) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[cnt] = i + 1;
//            recur(start + 1, cnt + 1); // 실수 주의!!!
            recur(i + 1, cnt + 1);
            visited[i] = false;
        }
    }
}
