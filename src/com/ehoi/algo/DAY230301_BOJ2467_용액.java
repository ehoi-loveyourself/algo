package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 완탐 -> 시간초과 */
public class DAY230301_BOJ2467_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int small = 0;
        int big = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = Math.abs(arr[i] + arr[j]);
                if (sum < min) {
                    min = sum;
                    small = arr[i];
                    big = arr[j];
                }
            }
        }

        System.out.printf("%d %d", small, big);
    }
}
