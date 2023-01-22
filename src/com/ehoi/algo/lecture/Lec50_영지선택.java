package com.ehoi.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lec50_영지선택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); // 입력완료

        int ans = 0;
        for (int i = 0; i < H - N; i++) {
            for (int j = 0; j < W - M; j++) {
                int sum = 0;
                for (int a = 0; a < N; a++) {
                    for (int b = 0; b < M; b++) {
                        sum += map[i + a][j + b];
                    }
                }
                ans = Math.max(ans, sum);
            }
        }
        System.out.println(ans);
        br.close();
    }
}
