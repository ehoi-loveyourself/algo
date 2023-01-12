package com.ehoi.algo.lecture;

import java.util.*;

public class Lec39_두배열합치기_강의버전 {
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

        int k = n + m;
        int[] c = new int[k];

        int pos_a = 0;
        int pos_b = 0;
        int pos_c = 0;
        while (pos_a < n && pos_b < m) {
            if (a[pos_a] <= b[pos_b]) {
                c[pos_c++] = a[pos_a++];
            } else {
                c[pos_c++] = b[pos_b++];
            }
        } // 적어도 한 쪽 배열이 있는 것은 다 담았다. 남은 곳에 있는 걸 옮겨 담자

        while (pos_a < n) {
            c[pos_c++] = a[pos_a++];
        }
        while (pos_b < m) {
            c[pos_c++] = b[pos_b++];
        }

        for (int i : c) {
            System.out.printf("%d ", i);
        }

        sc.close();
    }
}
