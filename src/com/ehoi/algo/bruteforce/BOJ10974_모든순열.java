package com.ehoi.algo.bruteforce;

import java.util.*;

public class BOJ10974_모든순열 {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] sel;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sel = new int[n];
        visited = new boolean[n];

        recur(0);

        System.out.println(sb);
        sc.close();
    }

    private static void recur(int cnt) {
        if (cnt == n) {
            for (int i : sel)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            sel[cnt] = i + 1;
            recur(cnt + 1);
            visited[i] = false;
        }
    }
}
