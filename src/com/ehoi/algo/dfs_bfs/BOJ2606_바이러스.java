package com.ehoi.algo.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2606_바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int computerCnt = Integer.parseInt(st.nextToken());
        int network = Integer.parseInt(br.readLine());

        // 인접리스트로 그래프 정보 받기
        List<Integer>[] graph = new ArrayList[computerCnt + 1];
        for (int  i = 1; i <= computerCnt; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < network; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // 방문처리 행렬
        boolean[] visited = new boolean[computerCnt + 1];

        // bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int virus = -1; // 1번 컴퓨터부터 세므로 -1에서 시작
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            virus++;
            for (int v : graph[poll]) {
                if (!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                }
            }
        }

        System.out.println(virus);
    }
}