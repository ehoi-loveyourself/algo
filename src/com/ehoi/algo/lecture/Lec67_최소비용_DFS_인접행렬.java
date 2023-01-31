package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec67_최소비용_DFS_인접행렬 {
    static int n, m;
    static int[][] graph;
    static int ans = 987654321;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int w = sc.nextInt();
            graph[s][e] = w;
        }
        visited[1] = true;
        dfs(1, 0);
        System.out.println(ans);
        sc.close();
    }

    private static void dfs(int v, int cost) {
        if (v == n) {
            ans = Math.min(ans, cost);
            return;
        }

        // 정점들 중에서
        for (int i = 1; i <= n; i++) {
            // 갈 수 있고 = 화살표가 있고 && 방문하지 않았다면
            if (graph[v][i] != 0) {
                if (visited[i]) continue;
                visited[i] = true;
                dfs(i, cost + graph[v][i]);
                visited[i] = false;
            }
        }
    }
}
