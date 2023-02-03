package com.ehoi.algo;

import java.util.*;

// 이 문제에서는 전선을 끊는게 중요해보이므로 쉽게 변환할 수 있는 인접행렬로 풀어야지
public class DAY230203_PRO_전력망을둘로나누기 {
    static int[][] adj;

    public int solution(int n, int[][] wires) {
        // 송전탑 개수를 최댓값으로 갱신
        int answer = n;
        adj = new int[n + 1][n + 1];

        // 전선 입력받기
        for (int i = 0; i < wires.length; i++) {
            adj[wires[i][0]][wires[i][1]] = 1;
            adj[wires[i][1]][wires[i][0]] = 1;
        }

        // 이제 전선 하나씩 끊으면서 bfs 들어갔다 오기
        for (int i = 0; i < wires.length; i++) {
            adj[wires[i][0]][wires[i][1]] = 0;
            adj[wires[i][1]][wires[i][0]] = 0;

            int cnt = bfs(1, n); // 한쪽 송전탑만 방문하고 센 개수

            // 나머지 하나는 n - cnt니까 둘의 차는 n - 2 * cnt
            answer = Math.min(answer, Math.abs(n - (2 * cnt)));

            adj[wires[i][0]][wires[i][1]] = 1;
            adj[wires[i][1]][wires[i][0]] = 1;
        }

        return answer;
    }

    private static int bfs(int v, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.add(v);
        visited[v] = true;

        int cnt = 1; // 이미 노드 하나 방문했으니까 1
        while (!q.isEmpty()) {
            int curr = q.poll();

            // 현재 노드랑 연결된 모든 노드 집어넣기
            for (int i = 1; i <= n; i++) {
                // 연결 안되어 있으면 빼고
                if (adj[curr][i] == 0) continue;
                // 방문 했어도 빼고
                if (visited[i]) continue;
                // 연결되어 있는 노드면
                visited[i] = true;
                q.add(i);
                cnt++;
            }
        }

        return cnt;
    }
}
