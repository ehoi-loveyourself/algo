package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DAY230201_BOJ11724_연결요소의개수 {
    static int n, cnt;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            cnt++;
            dfs(i);
        }

        System.out.println(cnt);
        br.close();
    }

    private static void dfs(int v) {
        for (int i = 0; i < graph[v].size(); i++) {
            int curr = graph[v].get(i);
            if (visited[curr]) continue;
            visited[curr] = true;
            dfs(curr);
        }
    }
}
