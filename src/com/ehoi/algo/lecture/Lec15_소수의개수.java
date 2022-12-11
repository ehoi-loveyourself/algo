package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec15_소수의개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. n 을 받는다.
        int n = sc.nextInt();
        // 2. 1부터 n까지 돌면서 소수 판별을 한다.
        // 소수라면 cnt++를 한다.
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                cnt++;
            }
        }
        // 3. cnt를 리턴한다.
        System.out.println(cnt);
    }

    private static boolean isPrime(int x) {
        if (x == 1) return false;
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
// 제한시간 1초
