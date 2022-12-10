package com.ehoi.algo.lecture;

import java.util.*;

public class Lec1_1부터_N까지_M의_배수합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int ans = 0;

        for (int i = 1; i <= N; i++) {
            if (i % M == 0) {
                ans += i;
            }
        }

        System.out.println(ans);
    }
}
