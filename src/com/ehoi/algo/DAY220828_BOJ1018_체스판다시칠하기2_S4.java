package com.ehoi.algo;

import java.io.*;
import java.util.*;

/*
 * 나는 char 배열을 가지고 풀었는데 풀이를 보니까
 * W, B 두 가지이기 때문에 boolean 배열을 쓰는 것을 보고
 * 그렇게 풀면 더 편해질 거 같아서 다시 풀어보기!
 */
public class DAY220828_BOJ1018_체스판다시칠하기2_S4 {
    static boolean[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                if(str.charAt(j) == 'W') {
                    arr[i][j] = true; // W이면 true
                } else {
                    arr[i][j] = false; // B이면 false
                }
            }
        } // 입력 끝

        // 검증 시작
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                find(i, j);
            }
        }

        System.out.println(min);
    }

    private static void find(int x, int y) {
        // 좌측 상단의 첫번째 색
        boolean color = arr[x][y];
        int count = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if(arr[i][j] != color) count++; // 색깔이 다르면 count 올리기

                // 다음 좌표 점검을 위해서 color 색 바꿔주기
                color = !color;
            }
            // 한 줄이 끝날 때도 또 바꿔주기
            // ? 근데 마지막이 흰 색이었으면 첫 번째 색도 흰색이어야 하는데?
            // 여기서는 안 바꾸는 게 맞지 않나
            // 바꾸는게 맞나봐
            color = !color;
        }

        count = Math.min(count, 64-count);
        min = Math.min(count, min);
    }
}
