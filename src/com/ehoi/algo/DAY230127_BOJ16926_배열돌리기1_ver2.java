package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DAY230127_BOJ16926_배열돌리기1_ver2 {
    static int h, w, k, count;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 끝
        System.out.println("전");
        System.out.println(Arrays.deepToString(map));

        count = Math.min(h, w) / 2;
        System.out.println("count : " + count);
        for (int i = 0; i < k; i++) {
            rotate();
        }
        System.out.println("후");
        System.out.println(Arrays.deepToString(map));
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.printf("%d ", map[i][j]);
            }
            System.out.println();
        }
    }

    // 1. 위쪽라인 : 오른쪽에 있는 친구
    // 2. 오른쪽라인 : 아래에 있는 친구
    // 3. 아래 : 왼쪽
    // 4. 왼쪽 : 위
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    private static void rotate() {
        for (int t = 0; t < count; t++) {
            int x = t;
            int y = t;

            int tmp = map[x][y];

            // 태이야 이렇게 돌리면 방향이 한번만 가고 바로 바뀌잖니... 바보야
            int idx = 0;
            while (idx < 4) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                // 범위를 벗어나면 방향 바꾸기
                if (nx < t || ny < t || nx >= h - t || ny >= w - t) {
                    idx++;
                } else {
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                }
            }

            map[t + 1][t] = tmp;
        }
    }
}
