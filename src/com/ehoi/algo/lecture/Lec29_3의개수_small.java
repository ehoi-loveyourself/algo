package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec29_3의개수_small {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '3') cnt++;
            }
        }
        System.out.println(cnt);
    }
}
