package com.ehoi.algo.dfs_bfs;

import java.util.*;

public class 게임맵최단거리 {
    public int solution(int[][] maps) {
        int answer = bfs(0, 0, maps);

        return answer;
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    private int bfs(int x, int y, int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        // 최단 거리를 작성할 정답 배열을 작성해야 한다!!!!
        int[][] dist = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0}); // 시작점
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int currX = curr[0];
            int currY = curr[1];

            for (int d = 0; d < 4; d++) {
                int nx = currX + dx[d];
                int ny = currY + dy[d];

                if (canMove(nx, ny, maps, dist)) {
                    dist[nx][ny] = dist[currX][currY] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        if (dist[n-1][m-1] == 0) return -1;
        else return dist[n-1][m-1];
    }

    private boolean canMove(int x, int y, int[][] maps, int[][] dist) {
        int n = maps.length;
        int m = maps[0].length;

        if (x < 0 || y < 0 || x >= n || y >= m) return false;
        if (maps[x][y] == 0) return false;
        if (dist[x][y] != 0) return false;
        return true;
    }
}