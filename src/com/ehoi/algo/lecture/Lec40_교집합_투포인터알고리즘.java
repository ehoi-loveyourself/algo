package com.ehoi.algo.lecture;

import java.util.Arrays;
import java.util.Scanner;

public class Lec40_교집합_투포인터알고리즘 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);

        int k = Math.min(n, m);
        int[] c = new int[k];
        int pos_a = 0; int pos_b = 0; int pos_c = 0;
        while (pos_a < n && pos_b < m) {
            if (a[pos_a] < b[pos_b]) {
                pos_a++;
            } else if (a[pos_a] == b[pos_b]) {
                c[pos_c++] = a[pos_a++];
                pos_b++;
            } else {
                pos_b++;
            }
        }
        /**
         * 배열 전체를 돌면서 0이 아닌 원소만 출력하기 보다는
         * 아래와 같이 하는 것이 좋아보임
        for (int i : c) {
            if (i == 0) continue;
            System.out.printf("%d ", i);
        }
         */

        // c의 포인터를 조건으로 잡는 것이 포인트
        for (int i = 0; i < pos_c; i++) {
            System.out.printf("%d ", c[i]);
        }
        sc.close();
    }
}
