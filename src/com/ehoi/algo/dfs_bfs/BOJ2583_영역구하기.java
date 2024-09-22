package com.ehoi.algo.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2583_영역구하기 {
    static int[][] map;
    static int width;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int c = 0; c < r; c++) {
            st = new StringTokenizer(br.readLine());
            int str_x = Integer.parseInt(st.nextToken());
            int str_y = Integer.parseInt(st.nextToken());
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());

            for (int i = str_x; i < end_x; i++) {
                for (int j = str_y; j < end_y; j++) {
                    map[i][j] = 1; // 색칠
                }
            }
        }

        // 방문한 곳은 2로 바꿔야지
        // 색칠이 안 된 곳을 찾아 dfs
        int cnt = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                    width = 0;
                    dfs(i, j);
                    q.add(width);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        while (!q.isEmpty()) {
            sb.append(q.poll()).append(" ");
        }
        System.out.println(sb);
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    private static void dfs(int r, int c) {
        if (!movable(r, c)) return;
        map[r][c] = 2;
        width++;
        for (int d = 0; d < 4; d++) {
            dfs(r + dx[d], c + dy[d]);
        }
    }

    // 범위 밖, 색칠되어 있는 공간, 방문한 공간
    private static boolean movable(int r, int c) {
        if (r < 0 || c < 0 || r >= map.length || c >= map[0].length) return false;
        if (map[r][c] == 1 || map[r][c] == 2) return false;
        return true;
    }
}