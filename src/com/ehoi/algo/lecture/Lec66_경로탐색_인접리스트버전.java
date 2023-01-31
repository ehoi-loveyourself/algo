package com.ehoi.algo.lecture;

import java.util.ArrayList;
import java.util.Scanner;

public class Lec66_경로탐색_인접리스트버전 {
    static int v; // 정점
    static int e; // 간선
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        graph = new ArrayList[v + 1];
        visited = new boolean[v + 1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            graph[s].add(e);
        }
        visited[1] = true;
        dfs(1);
        System.out.println(ans);
        sc.close();
    }

    private static void dfs(int from) {
        if (from == v) {
           ans++;
           return;
        }

        for (int i = 0; i < graph[from].size(); i++) {
            // 연결되어 있어 있는 것만 나올 거임
            // 방문하지 않았다면
            int tmp = graph[from].get(i); // 연결된 정점 찾아서 tmp에 넣기
            if (visited[tmp]) continue;
            visited[tmp] = true;
            dfs(tmp);
            visited[tmp] = false;
        }
    }
}
