package com.ehoi.algo.bruteforce;

import java.util.Scanner;

public class BOJ1748_수이어쓰기1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int target = 0;
        int pivot = 9;
        int d = 1;
        int ans = 0;

        while (N > target + pivot) {
            // N이 target 보다 크면 그 자리수 * 개수 만큼 정답에 더한다.
            ans += pivot * d;
            d++;
            target += pivot;
            pivot *= 10;
        }
        // 아니면
        ans += (N - target) * d;
        System.out.println(ans);
    }
}
