package com.ehoi.algo;

import java.util.*;
import java.io.*;

public class DAY221105_BOJ_S5_1010_다리놓기 {
    static int N, M, ans;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 1; i <= tc; i++) {
            N = sc.nextInt();
            M = sc.nextInt();

            visited = new boolean[M];
            ans = 0;
            comb(0, 0);

            System.out.println(ans);
        }
    }

    public static void comb(int idx, int cnt) {
        if (cnt == N) {
            ans++;
            return;
        }

        for (int i = idx; i < M; i++) {
            visited[i] = true;
            comb(idx + 1, cnt + 1);
            visited[i] = false;
        }
    }
}

// M개 중에서 N개를 조합할 수 있는 경우의 수를 구하는 문제