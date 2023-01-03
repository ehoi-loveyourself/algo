package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec21_카드게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];
        int[] b = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            b[i] = sc.nextInt();
        }
        String last_winner = "D";
        int sum_a = 0;
        int sum_b = 0;
        for (int i = 0; i < 10; i++) {
            if (a[i] > b[i]) {
                sum_a += 3;
                last_winner = "A";
            }
            else if (a[i] < b[i]) {
                sum_b += 3;
                last_winner = "B";
            }
            else {
                sum_a++;
                sum_b++;
            }
        }
        // 점수 출력
        System.out.printf("%d %d\n", sum_a, sum_b);
        // 누가 이겼는지 출력
        if (sum_a > sum_b) System.out.println("A");
        else if (sum_b > sum_a) System.out.println("B");
        else System.out.println(last_winner);
        sc.close();
    }
}
