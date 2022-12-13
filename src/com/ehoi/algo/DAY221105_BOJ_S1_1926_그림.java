package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY221105_BOJ_S1_1926_그림 {
    static int n, m, cnt;
    static int[][] map;
    static boolean[][] visited;
    static int space;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 끝
        int ans = 0;
        // dfs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    space = 1;
                    dfs(i, j);
                    cnt++;
                    ans = Math.max(ans, space);
                }
            }
        }

        // cnt 출력
        System.out.println(cnt);
        // space 가장 앞자리 출력
        System.out.println(ans);
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void dfs(int r, int c) {
        // 방문 처리
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
            if (visited[nr][nc]) continue;
            if (map[nr][nc] == 0) continue;

            visited[nr][nc] = true;
            space++;
            dfs(nr, nc);
        }
    }
}
