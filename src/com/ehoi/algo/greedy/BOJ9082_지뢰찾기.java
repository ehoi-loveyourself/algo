package com.ehoi.algo.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9082_지뢰찾기 {

    public static void main(String[] args) throws IOException {
        // 테스트 케이스 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());

            // 지뢰 개수 받기
            char[] bombs = br.readLine().toCharArray();
            int[] intBombs = new int[n];
            for (int j = 0; j < bombs.length; j++) {
                intBombs[j] = bombs[j] - '0';
            }

            // 지뢰 힌트 받아서 그냥 버리기
            br.readLine();

            int bomb = 0;
            for (int j = 0; j < n; j++) {
                if (j == 0) { // 제일 왼쪽 검사
                    if (intBombs[j] != 0 && intBombs[j + 1] != 0) {
                        intBombs[j]--;
                        intBombs[j + 1]--;
                        bomb++;
                    }
                } else if (j == n - 1) { // 제일 오른쪽 검사
                    if (intBombs[j] != 0 && intBombs[j - 1] != 0) {
                        intBombs[j]--;
                        intBombs[j - 1]--;
                        bomb++;
                    }
                } else { // 가운데 있는 애들
                    if (intBombs[j] != 0 && intBombs[j - 1] != 0 && intBombs[j + 1] != 0) {
                        intBombs[j]--;
                        intBombs[j - 1]--;
                        intBombs[j + 1]--;
                        bomb++;
                    }
                }
            }
            System.out.println(bomb);
        }
    }
}