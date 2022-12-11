package com.ehoi.algo.lecture;

import java.util.Arrays;
import java.util.Scanner;

public class Lec13_가장많이사용된자릿수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] cnt = new int[10];

        while (n > 0) {
            cnt[n % 10]++;
            n /= 10;
        }

        int max = 0;
        int ans = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (max <= cnt[i]) {
                max = cnt[i];
                ans = i;
            }
        }

        System.out.println(ans);
    }
}
