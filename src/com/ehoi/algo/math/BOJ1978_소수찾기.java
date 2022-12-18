package com.ehoi.algo.math;

import java.util.Scanner;

public class BOJ1978_소수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (isPrime(num)) cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean isPrime(int num) {
        if (num == 1) return false;
        boolean flag = true;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
