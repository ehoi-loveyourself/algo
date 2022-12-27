package com.ehoi.algo.bruteforce;

import java.io.*;
import java.util.*;

public class BOJ6064_카잉달력 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (y == N) y = 0;

            int lcm = M * N / gcd(M, N);
            int idx = 0;
            int ans = -1;
            while (true) {
                // x를 만족하는 year를 먼저 추리기
                int year = M * idx + x;
                // y도 만족한다면 ans 도출
                if (year % N == y) {
                    ans = year;
                    break;
                }
                // year의 범위까지 찾지 못했다면 break
                if (year > lcm) break;

                idx++;
            }
            System.out.println(ans);
        }
        sc.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }
}
