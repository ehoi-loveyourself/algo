package com.ehoi.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lec48_각행의평균과가장가까운값_리팩토링포함 {
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
//            avg[i] = Math.round((float) sum / 9);
            avg[i] = Math.round(sum / 9f);
//        } // 입력과 평균값 구하기 완료
//
//        for (int i = 0; i < 9; i++) { // 굳이 이중포문 두번 열지 말고 한번에 바로 가능
            int min = 100;
            int ans = 0;
            for (int j = 0; j < 9; j++) {
                int tmp = Math.abs(map[i][j] - avg[i]);
                if (tmp < min) {
                    // 같을 때도 봐줘야해!!
                    min = Math.abs(map[i][j] - avg[i]);
//                    ans = Math.max(ans, map[i][j]);  // 틀렸음. 왜냐하면 이 코드는 min과 같을 때만 적용해야 하기 때문
                    ans = map[i][j];
                } else if (tmp == min) {
                    if (map[i][j] > ans) ans = map[i][j];
                }
            }
            System.out.printf("%d %d\n", avg[i], ans);
        }
        br.close();
    }
}
