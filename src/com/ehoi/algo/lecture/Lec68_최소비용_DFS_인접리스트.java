package com.ehoi.algo.lecture;

import java.util.ArrayList;
import java.util.Scanner;

public class Lec68_최소비용_DFS_인접리스트 {
    static int n, m;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int ans = 987654321;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int w = sc.nextInt();
            graph[s].add(new Node(e, w));
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

        // v에서 갈수 있는 애들만 담겨있어
        for (int i = 0; i < graph[v].size(); i++) {
            Node curr = graph[v].get(i);
            if (visited[curr.e]) continue;
            visited[curr.e] = true;
            dfs(curr.e, cost + curr.w);
            visited[curr.e] = false;
        }
    }

    private static class Node {
        int e;
        int w;

        public Node(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }
}
