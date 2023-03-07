package com.ehoi.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lec82_순열구하기_DFS {
    private static int res;
    private static int[] arr;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 자연수 n개
        int r = Integer.parseInt(st.nextToken()); // 고를 개수

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n];
        comb(0, r, "");
        System.out.println(res);
    }

    private static void comb(int cnt, int r, String ans) {
        if (cnt == r) {
            System.out.println(ans);
            res++;
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            comb(cnt + 1, r, ans + arr[i] + " ");
            visited[i] = false;
        }
    }
}
