package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec64_경로탐색_DFS {
    static int ans, n, m;
    static boolean[][] graph;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 정점 수
        m = sc.nextInt(); // 간선 수
        visited = new boolean[n + 1];
        graph = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            graph[sc.nextInt()][sc.nextInt()] = true; // 갈수 있는 길을 true
        }
        visited[1] = true;
        dfs(1);
        System.out.println(ans);
        sc.close();
    }

    private static void dfs(int from) {
        // 종료 조건 : 출발해온 값이 5면 ans++
        if (from == n) {
            ans++;
            return;
        }

        // 재귀
        // 갈 수 있는 길을 찾아본다
        // 방문하지 않았다면 방문처리하고 간다.
        // 다녀왔을 때는 방문처리를 푼다.
        for (int i = 1; i <= n; i++) {
            if (graph[from][i]) {
                if (visited[i]) continue;
                visited[i] = true;
                dfs(i);
                visited[i] = false;
            }
        }
    }
}
