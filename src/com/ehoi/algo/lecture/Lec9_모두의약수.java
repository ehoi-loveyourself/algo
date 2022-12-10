package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec9_모두의약수 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int num = sc.nextInt();
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 1; i <= num; i++) {
//            int cnt = 0;
//            for (int j = 1; j <= i; j++) {
//                if (i % j == 0) cnt++;
//            }
//            sb.append(cnt).append(" ");
//        }
//
//        System.out.println(sb);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] cnt = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            for (int j = i; j <= num; j = j + i) {
                cnt[j]++;
            }
        }

        for (int i = 1; i < cnt.length; i++) {
            System.out.print(cnt[i] + " ");
        }
    }
}

// 1초 이내로 풀기
// N이 50,000까지 주어짐