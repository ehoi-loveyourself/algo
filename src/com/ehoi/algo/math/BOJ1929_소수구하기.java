package com.ehoi.algo.math;

import java.util.Scanner;

public class BOJ1929_소수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        for (int i = m; i <= n; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int num) {
        boolean flag = true;
        for (int i = 2; i * i <= num; i++) {
            if (num % i ==0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
