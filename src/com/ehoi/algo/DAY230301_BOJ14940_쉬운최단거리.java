package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DAY230301_BOJ14940_쉬운최단거리 {
    static int targetX, targetY, n, m;
    static int[][] map, ans;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        ans = new int[n][m];

        // 목표 지점 좌표 기억하기
        targetX = 0;
        targetY = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    targetX = i;
                    targetY = j;
                } else if (map[i][j] == 0) {
                    ans[i][j] = 0;
                } else {
                    ans[i][j] = -1;
                }
            }
        } // 입력 완료

//        for (int i = 0; i < n; i++) {
//            Arrays.fill(ans[i], -1);
//        }
        // 목표지점부터 bfs
        bfs(targetX, targetY);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    private static void bfs(int x, int y) {
        ans[x][y] = 0; // 목표지점은 거리가 0이므로
        visited[x][y] = true;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point curr = q.poll();

            int r = curr.x;
            int c = curr.y;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (visited[nr][nc]) continue; // 방문체크
                if (map[nr][nc] == 0) continue;
                ans[nr][nc] = ans[r][c] + 1;
                visited[nr][nc] = true;
                q.add(new Point(nr, nc));
            }
        }
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
