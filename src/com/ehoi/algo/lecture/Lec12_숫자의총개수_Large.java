package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec12_숫자의총개수_Large {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int c = 1;
        int d = 9;
        int target = 0;
        int ans = 0;

        while (N > target + d) {
            ans += c * d;
            c++;
            target += d;
            d *= 10;
        }
        ans += (N - target) * c;

        System.out.println(ans);
    }
}
