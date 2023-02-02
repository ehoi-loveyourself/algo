package com.ehoi.algo;

import java.util.Arrays;

public class DAY230202_PRO_네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        // 아직 탐색을 하지 않는 컴퓨터는 탐색을 하러 들어간다
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, computers);
                // 탐색을 하고 나오면 정답++
                answer++;
            }
        }

        System.out.println(Arrays.toString(visited));
        return answer;
    }

    private static void dfs(int i, boolean[] visited, int[][] computers) {
        // 탐색하러 들어온 컴퓨터 방문처리
        visited[i] = true;

        // 남은 컴퓨터 중에 탐색할 수 있는 컴퓨터를 찾자
        for (int j = 0; j < computers.length; j++) {
            // 나 스스로는 안돼
            // 이미 탐색한 컴퓨터도 안돼
            // 그리고 연결이 안되어 있으면 안돼
            if (i == j) continue;
            if (visited[j]) continue;
            if (computers[i][j] == 0) continue;
            dfs(j, visited, computers);
        }
    }
}