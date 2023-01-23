package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec56_재귀함수분석 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        recur(n);
        sc.close();
    }

    private static void recur(int n) {
        if (n == 0) return;

        recur(n - 1);
        System.out.printf("%d ", n);
    }
}
