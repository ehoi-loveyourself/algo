package com.ehoi.algo.bruteforce;

import java.util.*;

public class BOJ15649_N과M1 {
    static int N, M;
    static int[] ans;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N];
        ans = new int[M];

        recur(0);
        System.out.println(sb);
        sc.close();
    }

    private static void recur(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < ans.length; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            ans[cnt] = i + 1;
            visited[i] = true;
            recur(cnt + 1);
            visited[i] = false;

        }
    }
}
