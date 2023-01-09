package com.ehoi.algo.lecture;

import java.util.Scanner;

/**
 * n의 범위가 1000가지다. 1000!을 하게 되면 long으로도 취급할 수 없는 크기의 수가 나온다.
 * 그래서 내가 짠 코드로는 답이 나올 수 없다.
 * 정답 버전을 확인해라
 */
public class Lec28_N팩토리얼에서0의개수_틀린버전 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        n = factorial(n);
        String str_n = String.valueOf(n);
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < str_n.length(); i++) {
            if (str_n.charAt(i) == '0') {
                cnt++;
            } else {
                max = Math.max(max, cnt);
                cnt = 0;
            }
        }

        System.out.println(max);
        sc.close();
    }

    private static long factorial(long n) {
        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}
