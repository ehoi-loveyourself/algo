package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec41_연속된자연수의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        for (int i = n / 2; i >= 1; i--) {
            int sum = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = i; j <= n / 2 + 1; j++) {
                sum += j;
                if (sum == n) {
                    sb.append(j).append(" = 15");
                    System.out.println(sb);
                    cnt++;
                    break;
                }
                if (sum < n) sb.append(j).append(" + ");
                if (sum > n) break;
            }
        }
        System.out.println(cnt);
        sc.close();
    }
}
