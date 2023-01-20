package com.ehoi.algo.lecture;

import java.io.*;
import java.util.*;

public class Lec47_봉우리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 지도 크기
        int[][] map = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 완료

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int ans = 0;
        // boolean flag = true; // 여기 아님 주의
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                boolean flag = true; // 봉우리일거야
                int curr = map[i][j];
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (curr <= map[nx][ny]) { // 봉우리가 아니네
                        flag = false;
                        break;
                    }
                }
                if (flag) ans++;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
