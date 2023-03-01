package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY230301_BOJ2467_용액_투포인터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n - 1;

        int small = 0;
        int big = 0;
        int min = Integer.MAX_VALUE;
        while (left < right) {
            int sum = arr[left] + arr[right];
            // 최솟값 갱신하면서 값도 갱신
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                small = arr[left];
                big = arr[right];
            }

            // 포인터 이동
            if (sum > 0) right--;
            else if (sum < 0) left++;
            else break;
        }
        System.out.printf("%d %d", small, big);
    }
}
