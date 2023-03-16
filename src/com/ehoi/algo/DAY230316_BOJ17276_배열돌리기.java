package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY230316_BOJ17276_배열돌리기 {
    static int n, degree;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 맵의 크기
            degree = Integer.parseInt(st.nextToken()); // 돌아가는 각도

            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            rotate();
            print();
        }
        System.out.println(sb);
        br.close();
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static void rotate() {
        int cnt = getCnt(degree);

        for (int t = 0; t < cnt; t++) {
            for (int c = 0; c < n / 2; c++) {
                int x = c;
                int y = c;
                int tmp = map[x][y];

                int dist = n / 2 - c;

                int idx = 0;
                while (idx < 4) {
                    int nx = x + dx[idx] * dist;
                    int ny = y + dy[idx] * dist;

                    // 범위 체크
                    if (nx < c || ny < c || nx >= n - c || ny >= n - c) {
                        idx ++;
                    } else {
                        map[x][y] = map[nx][ny];
                        x = nx;
                        y = ny;
                    }
                }

                // tmp 처리
                map[c][c + dist] = tmp;
            }
        }
    }

    private static int getCnt(int degree) {
        int cnt = degree / 45;
        if (cnt == 8) cnt = 0;
        if (cnt < 0) cnt += 8;

        return cnt;
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }
}
