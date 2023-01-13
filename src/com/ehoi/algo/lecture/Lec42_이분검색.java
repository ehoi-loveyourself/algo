package com.ehoi.algo.lecture;

import java.util.Arrays;
import java.util.Scanner;

public class Lec42_이분검색 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int pos = n / 2;
        int c = pos;
        int ans = 0;
        while (true) {
            c /= 2;
            if (a[pos] == target) {
                ans = pos;
                break;
            }
            if (a[pos] > target) {
                pos -= c;
            }
            if (a[pos] < target) {
                pos += c;
            }
        }
        System.out.println(ans + 1);
        sc.close();
    }
}
