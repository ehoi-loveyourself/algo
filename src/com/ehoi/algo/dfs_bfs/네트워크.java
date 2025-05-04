package com.ehoi.algo.dfs_bfs;

public class 네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, computers);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int i, boolean[] visited, int[][] computers) {
        visited[i] = true;

        for (int j = 0; j < visited.length; j++) {
            if (i == j) continue;
            if (visited[j]) continue;
            if (computers[i][j] == 0) continue;
            dfs(j, visited, computers);
        }
    }
}