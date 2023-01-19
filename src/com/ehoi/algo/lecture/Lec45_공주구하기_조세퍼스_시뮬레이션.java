package com.ehoi.algo.lecture;

import java.util.*;

public class Lec45_공주구하기_조세퍼스_시뮬레이션 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        boolean[] p = new boolean[n + 1];
        int pos = 0;
        int cnt = 0;
        int bp = 0;

        while (true) {
            pos++;
            if (pos > n) pos = 1;
            if (!p[pos]) { // false 일 때만 처리하게
                cnt++;
                if (cnt == k) {
                    p[pos] = true;
                    cnt = 0;
                    bp++;
                }
            }
            if (bp == n - 1) break;
        }
        for (int i = 1; i <= n; i++) {
            if (!p[i]) System.out.println(i);
        }
        sc.close();
    }
}
