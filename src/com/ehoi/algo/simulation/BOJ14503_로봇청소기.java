package com.ehoi.algo.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503_로봇청소기 {
    private static int d;
    private static int[][] map;
    private static int clean = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, d);
        System.out.println(clean);
    }

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    private static void clean(int r, int c, int d) {
        // 1. 현재 칸 청소
        if (map[r][c] == 0) {
            map[r][c] = 2;
            clean++;
        }

        // 2. 회전하면서 청소할 곳을 탐색
        for (int i = 0; i < 4; i++) {
            d = (d + 1) % 4;
            int nr = r + dx[d];
            int nc = c + dy[d];

            if (!canMove(nr, nc)) continue;

            if (map[nr][nc] == 0) {
                clean(nr, nc, d);
                return;
            }
        }

        // 3. 청소할 곳이 없어! 후진하자
        // 후진 불가능하면 리턴
        if (!canMove(r - dx[d], c - dy[d])) return;
        // 가능하면 다시 청소
        clean(r - dx[d], c - dy[d], d);
    }

    private static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < map.length && c < map[0].length && map[r][c] != 1;
    }
}