package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY220828_BOJ1018_체스판다시칠하기_S4 {
    static int N, M;
    static char[][] arr;
    // MAX_VALUE를 줬었는데 다른 풀이를 보니 64라고 적혀있었다. 그 이유는 최대 64를 넘지 않기 때문임.. 천재다
    static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        // 전체 보드판에 대하여 8*8 체스판 형태로 검증
        // 검증해야 하는 범위를 한정짓자
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                find(i, j);
            }
        }

        System.out.println(min);
    }

    // 8 * 8 체스판에 대하여 제자리에 있지 않은 애들을 찾아 count를 더해줄 것이다.
    private static void find(int x, int y) {
        char color = arr[x][y]; // 기준점이 될 좌측 상단의 색깔
        int count = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (arr[i][j] != color) {
                    count++;
                }

                // 그 다음 비교를 위해 색깔을 바꿔줌
                if (color == 'W') color = 'B';
                else color = 'W';
            }
            // 다음 줄로 넘어갈 때도 색깔을 바꿔줌
            if (color == 'W') color = 'B';
            else color = 'W';
        } // 검사 끝

        // 이제 최소값 검사를 해야함
        // 그 전에 color가 color였을 때 바꿀 값이 더 작을지, !color였을 때 바꿀 값이 더 작을지를 골라야함
        count = Math.min(count, 64-count);
        min = Math.min(count, min);
    }
}
