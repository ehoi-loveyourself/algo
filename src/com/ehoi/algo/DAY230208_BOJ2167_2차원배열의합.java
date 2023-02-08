package com.ehoi.algo;

import java.io.*;
import java.util.StringTokenizer;

public class DAY230208_BOJ2167_2차원배열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            int sum = 0;
            for (int i = a; i <= x; i++) {
                for (int j = b; j <= y; j++) {
                    sum += arr[i][j];
                }
            }

            System.out.println(sum);
        }

        br.close();
    }
}
