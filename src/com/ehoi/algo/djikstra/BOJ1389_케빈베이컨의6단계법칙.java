package com.ehoi.algo.djikstra;

import java.io.*;
import java.util.*;

public class BOJ1389_케빈베이컨의6단계법칙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]); // 유저 수
        int m = Integer.parseInt(firstLine[1]); // 친구 관계 수

        // 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 친구 관계 입력
        for (int i = 0; i < m; i++) {
            String[] info = br.readLine().split(" ");
            int a = Integer.parseInt(info[0]);
            int b = Integer.parseInt(info[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int minKevinBacon = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            // 모든 유저들에 대해 BFS 실행
            int sum = bfs(i, n, graph);
            if (sum < minKevinBacon) {
                minKevinBacon = sum;
                ans = i;
            }
        }

        System.out.println(ans);
    }

    public static int bfs(int start, int n, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[n + 1];

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            // curr의 친구를 찾자
            for (int friend : graph.get(curr)) {
                if (!visited[friend]) {
                    visited[friend] = true;
                    // 이 친구는 지금 친구에서 1을 더 가야만 가까운 친구임
                    dist[friend] = dist[curr] + 1;
                    queue.add(friend);
                }
            }
        }

        // 이제 친구거리의 합 = 케빈 베이컨 구하기
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += dist[i];
        }
        return sum;
    }
}