package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec57_재귀함수이진수출력 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        recur(n);
        sc.close();
    }

    private static void recur(int n) {
        if (n == 0) return;

        recur(n / 2);
        System.out.printf("%d", n % 2);
    }
}
