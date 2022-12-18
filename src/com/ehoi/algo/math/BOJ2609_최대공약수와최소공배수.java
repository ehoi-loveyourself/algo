package com.ehoi.algo.math;

import java.util.Scanner;

public class BOJ2609_최대공약수와최소공배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        int min = sc.nextInt();
        if (max < min) {
            int swap = min;
            min = max;
            max = swap;
        }
        int GCD = calGCD(max, min);
        int GCM = max * min / GCD;
        System.out.println(GCD);
        System.out.println(GCM);
    }

    private static int calGCD(int max, int min) {
        if (min == 0) return max;

        return calGCD(min, max % min);
    }
}
