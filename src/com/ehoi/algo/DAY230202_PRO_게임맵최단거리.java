package com.ehoi.algo;

import java.util.LinkedList;
import java.util.Queue;

// 최단거리는 BFS 가 빠르다고 해서 풀었더니 잘 풀렸다!
// 역시 학습의 효과!
public class DAY230202_PRO_게임맵최단거리 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        // 최단 거리 작성할 정답 배열 작성
        int[][] dist = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0}); // 시작점부터 입장
        dist[0][0] = 1; // 시작한 곳 거리 1로 지정

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int currX = curr[0];
            int currY = curr[1];

            for (int d = 0; d < 4; d++) {
                int nx = currX + dx[d];
                int ny = currY + dy[d];

                // 범위체크
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                // 벽이거나 이미 방문한 곳이면
                if (maps[nx][ny] == 0 || dist[nx][ny] != 0) continue;
                // 이제 갈 수 있다 방문처리
                dist[nx][ny] = dist[currX][currY] + 1;
                q.add(new int[]{nx, ny});
            }
        }
        if (dist[n - 1][m - 1] == 0) return -1;
        else return dist[n - 1][m - 1];
    }
}

/*
0, 0 -> n - 1, m - 1까지
*/