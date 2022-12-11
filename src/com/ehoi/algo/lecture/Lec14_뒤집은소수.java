package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec14_뒤집은소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // 1. 숫자를 입력 받는다.
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int reversed = reverse(num);
            if (isPrime(reversed)) {
                sb.append(reversed).append(" ");
            }
        }
        System.out.println(sb);
        // 2. 배열을 돌면서 숫자를 뒤집는다.
        // 뒤집었을때 019는 19로 판별해야 한다.


        // 3. 뒤집은 숫자를 가지고 소수인지 판별한다.

        // 4. 소수라면 출력한다.
        // StringBuilder 쓸까
    }

    private static boolean isPrime(int x) {
        // x가 1일 때 이 상태로만 소수라고 판별할 것이므로
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

    private static int reverse(int x) {
        int res = 0;
        while (x > 0) {
            int tmp = x % 10;
            x /= 10;
            res = res * 10 + tmp;
        }
        return res;
    }
}
