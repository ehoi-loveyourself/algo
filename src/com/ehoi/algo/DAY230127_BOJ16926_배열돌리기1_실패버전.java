package com.ehoi.algo;

import java.io.*;
import java.util.*;

public class DAY230127_BOJ16926_배열돌리기1_실패버전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 끝

        // 몇 겹을 연산해야 할까?
        int count = Math.min(h, w) / 2;
        // k 만큼
        for (int c = 0; c < k; c++) {
            for (int i = 0; i < count; i++) {
                // 가장 먼저 덮어씌어질 첫번째 원소 저장해두기
                int tmp = map[i][i]; // (0, 0) (1, 1) (2, 2) 순임

                // 위 쪽 라인 옮길 거임 (0, 1) -> (0, 0) => (0, 2) -> (0, 1) => ...
                // 행은 고정되어 있으므로 i가 그 역할을 해주고
                // j가 열을 움직여줄 것임
                for (int j = i + 1; j <= w - 1 - i; j++) {
                    map[i][j - 1] = map[i][j];
                }

                // 오른쪽 라인 옮길 거임 (1, w - 1) -> (0, w - 1) => (2, w - 1) -> (1, w - 1) => ... (h - 1, w - 1) => (h - 2, w - 1)
                // 이번에는 열이 고정되어 있으므로 열에서 i를 활용
                // 행의 범위가 1부터 h - 1 까지 -> 2부터 h - 2까지
                for (int j = i + 1; j <= h - 1 - i; j++) {
                    map[j - 1][w - 1 - i] = map[j][w - 1 - i];
                }

                // 아래쪽 라인 (행, w - 2) -> (행, w - 1) => ( , w-3) -> ( , w-2) => ... ( , 0) -> ( , 1)
                // 행 고정이므로 i 활용 (h - 1 - i)
                // 열의 범위가 w - 2 부터 0 까지 -> w - 3부터 1까지
                for (int j = w - 2 - i; j >= i; j--) {
                    map[h - 1 - i][j + 1] = map[h - 1 - i][j];
                }

                // 왼쪽 라인 행만 나열 : h-2 -> h-1 | h-3 -> h-2 | 1 -> 2
                // 열이 고정 (i)
                // 행의 범위가 h-2부터 1까지
                for (int j = h - 2 - i; j > i; j--) {
                    map[j + 1][i] = map[j][i];
                }

                map[i + 1][i] = tmp;
            }
        }
        // 이제 출력
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.printf("%d ", map[i][j]);
            }
            System.out.println();
        }

        br.close();
    }
}
