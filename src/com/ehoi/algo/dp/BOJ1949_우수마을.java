package com.ehoi.algo.dp;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

public class BOJ1949_우수마을 {

    static Vector<Integer>[] vectors;
    static int[][] dp;
    static int[] persons;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 마을 개수
        int n = Integer.parseInt(st.nextToken());

        // 마을 별 인원수
        persons = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            persons[i] = Integer.parseInt(st.nextToken());
        }

        // 마을 인접 정보
        vectors = new Vector[n + 1]; // 벡터를 잘 모르지만 문제 풀이가 쓰길래 한번 써봄
        for (int i = 0; i <= n; i++) {
            vectors[i] = new Vector<>(); // 초기화 해주기
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            vectors[a].add(b);
            vectors[b].add(a);
        }

        dp = new int[n + 1][2]; // 0은 n마을이 우수마을이 아닐때, 1은 n마을이 우수마을 일 때

        dfs(1, 0);

        bw.write(Math.max(dp[1][0], dp[1][1]) + "\n");
        bw.flush();
    }

    public static void dfs(int n, int parent) {
        for (int node : vectors[n]) {
            if (node != parent) {
                dfs(node, n);
                dp[n][0] += Math.max(dp[node][0], dp[node][1]);
                dp[n][1] += dp[node][0];
            }
        }

        dp[n][1] += persons[n];
    }
}