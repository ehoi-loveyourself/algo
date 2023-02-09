package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY230209_BOJ16931_겉넓이구하기 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 위와 아래 면적 넓이 먼저 더하기
        // 종이 한칸에 무조건 한개의 정육면체는 놓이므로
        int sum = n * m * 2;

        // 옆의 겉넓이 구하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    // 범위 밖을 벗어나면 내가 가장 가장자리이므로 내 높이만큼 더하면 돼
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        sum += map[i][j];
                        continue;
                    }
                    // 범위 안에 있는데 내가 옆에 있는 애보다 높다면 나 - 그 애 만큼 더하면 돼
                    if (map[i][j] > map[nx][ny]) {
                        sum += map[i][j] - map[nx][ny];
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
