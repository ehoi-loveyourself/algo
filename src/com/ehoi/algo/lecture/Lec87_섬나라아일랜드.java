package com.ehoi.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lec87_섬나라아일랜드 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 완료

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    // 대각선까지
    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    private static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Pair poll = q.poll();

            for (int d = 0; d < 8; d++) {
                int nx = poll.x + dx[d];
                int ny = poll.y + dy[d];

                // 범위체크
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;
                // 방문도 한적 없고, 섬이라면
                q.add(new Pair(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }

    private static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
