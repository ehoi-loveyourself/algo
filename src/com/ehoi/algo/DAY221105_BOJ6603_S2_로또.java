package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY221105_BOJ6603_S2_로또 {
    static boolean[] visited;
    static int[] arr;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while (true) {
            String tc = br.readLine();
            if (tc.equals("0")) break; // 종료조건 설정

            String[] str = tc.split(" ");
            K = Integer.parseInt(str[0]);
            arr = new int[K];
            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(str[i + 1]);
            }
            visited = new boolean[K];
            comb(0, 0);
            System.out.println();
        }
    }

    public static void comb(int idx, int cnt) {
        // 종료 조건
        if (cnt == 6) {
            for (int i = 0; i < K; i++) {
                if (visited[i]) System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        for (int i = idx; i < K; i++) {
            visited[i] = true;
            comb(i + 1, cnt + 1);
            visited[i] = false;
        }
    }
}
