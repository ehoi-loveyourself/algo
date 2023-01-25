package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY230126_BOJ색종이만들기 {
    static int n, blue, white;
    static int[][] map;
    static final int WHITE = 0;
    static final int BLUE = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 끝
        divide(1, 1, n);
        System.out.println(white);
        System.out.println(blue);
        br.close();
    }

    private static void divide(int r, int c, int size) {
        if (size == 1) {
            if (map[r][c] == WHITE) white++;
            else blue++;
        } else if (!isSame(r, c, size)) {
            size /= 2;
            divide(r, c, size);
            divide(r, c + size, size);
            divide(r + size, c, size);
            divide(r + size, c + size, size);
        }
    }

    private static boolean isSame(int r, int c, int size) {
        boolean flag = true;
        int pivot = map[r][c];

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[i][j] != pivot) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            if (pivot == WHITE) white++;
            else blue++;
        }
        return flag;
    }
}
