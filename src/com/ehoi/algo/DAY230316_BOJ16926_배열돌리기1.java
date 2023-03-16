package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY230316_BOJ16926_배열돌리기1 {
    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 행
        m = Integer.parseInt(st.nextToken()); // 열
        int r = Integer.parseInt(st.nextToken()); // 회전해야하는 수

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 돌려야 하는 겹이 몇 개일까?
        int cnt = Math.min(n, m) / 2;

        // 그 겹만큼 돌린다
        for (int i = 0; i < r; i++) {
            rotate(cnt);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%d ", map[i][j]);
            }
            System.out.println();
        }

        br.close();
    }

    // 위, 오, 아, 왼 순으로
    // 오른쪽에서 가져오고 - 밑에서 올려오고 - 왼쪽에서 가져오고 - 위에서 내려야 해
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    private static void rotate(int cnt) {
        for (int t = 0; t < cnt; t++) {
            int x = t;
            int y = t;

            int tmp = map[x][y];

            int idx = 0;
            while (idx < 4) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                // 범위를 벗어났으면 방향 바꾸기
                if (nx < t || ny < t || nx >= n - t || ny >= m - t) {
                    idx++;
                } else {
                    // 아니면 이동시키기
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                }
            }

            // tmp 처리
            map[t + 1][t] = tmp;
        }
    }
}
