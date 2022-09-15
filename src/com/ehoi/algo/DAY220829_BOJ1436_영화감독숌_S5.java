package com.ehoi.algo;

import java.util.*;

public class DAY220829_BOJ1436_영화감독숌_S5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N번째로 666을 포함하는 수를 구하라

        int num = 665;
        int cnt = 0;

        while (true) {
            num++;
            if(String.valueOf(num).contains("666")) {
                cnt++;
            }

            if (cnt == N) {
                break;
            }
        }

        System.out.println(num);
    }
}
