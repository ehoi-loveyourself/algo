package com.ehoi.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lec48_각행의평균과가장가까운값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] map = new int[9][9];
        int[] avg = new int[9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
            }
            avg[i] = Math.round((float) sum / 9);
        } // 입력과 평균값 구하기 완료

        for (int i = 0; i < 9; i++) {
            int min = 100;
            int ans = 0;
            for (int j = 0; j < 9; j++) {
                if (Math.abs(map[i][j] - avg[i]) < min) {
                    min = Math.abs(map[i][j] - avg[i]);
                    ans = map[i][j];
                }
            }
            System.out.printf("%d %d\n", avg[i], ans);
        }
        br.close();
    }
}
