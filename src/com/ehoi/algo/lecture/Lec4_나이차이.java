package com.ehoi.algo.lecture;

import java.util.*;

public class Lec4_나이차이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int max = 0;
        int min = 987654321;

        for (int i = 0; i < N; i++) {
            int age = sc.nextInt();
            max = Math.max(max, age);
            min = Math.min(min, age);
        }

        System.out.println(max - min);
    }
}
