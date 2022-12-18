package com.ehoi.algo.math;

import java.util.Scanner;

public class BOJ17427_약수의합2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 숫자를 입력받고
        int n = sc.nextInt();
        // 그 숫자 + 1 만큼 배열을 만들고
        int[] arr = new int[n + 1];
        // 이중 포문을 돌면서 배열을 만든다
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                arr[j] += i;
            }
        }
        // 그리고 sum을 구하면 됨
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
