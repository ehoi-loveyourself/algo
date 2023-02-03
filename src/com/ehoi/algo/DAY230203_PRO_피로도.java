package com.ehoi.algo;

public class DAY230203_PRO_피로도 {
    private static int answer = -1;
    private static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);

        return answer;
    }

    private static void dfs(int cnt, int k, int[][] dungeons) {
        answer = Math.max(cnt, answer);

        if (cnt == dungeons.length) return;

        // 전체 던전 중
        for (int i = 0; i < dungeons.length; i++) {
            // 이미 탐험한 곳은 빼고
            if (visited[i]) continue;
            // 현재 피로도보다 최소 필요 피로도가 더 크면 빼고
            if (k < dungeons[i][0]) continue;
            // 아니면 탐험하러 가자
            visited[i] = true;
            // 소모피로도를 빼고
            dfs(cnt + 1, k - dungeons[i][1], dungeons);
            visited[i] = false;
        }
    }
}