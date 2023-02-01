package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DAY230201_BOJ13023 {
    static int n;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean ans = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        // 모든 정점에서 돌아봐야지!
        for (int i = 0; i < n; i++) {
            visited = new boolean[n]; // 매번 갈 때마다 초기화
            // 친구 관계가 성립하면
            dfs(i, 0);
            if (ans) break;
        }
        if (ans) System.out.println(1);
        else System.out.println(0);
        br.close();
    }

    private static void dfs(int v, int cnt) {
        if (cnt == 4) {
            ans = true;
            return;
        }

        visited[v] = true;
        // 나와 친구인 애들이 있으면 cnt + 1 해서 재귀 돌리기
        for (int i = 0; i < graph[v].size(); i++) {
            int friend = graph[v].get(i);
            if (visited[friend]) continue;
            dfs(friend, cnt + 1);
        }
        visited[v] = false;
    }
}
