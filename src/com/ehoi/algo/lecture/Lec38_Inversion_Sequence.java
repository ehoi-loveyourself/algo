package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec38_Inversion_Sequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        int[] big = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            big[i] = sc.nextInt();
        }

        for (int i = 7; i >= 1; i--) {
            int gap = big[i];
            int j;
            for (j = i; j < i + gap; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = i;
        }

        for (int i = 1; i <= n; i++) {
            System.out.printf("%d ", arr[i]);
        }
        sc.close();
    }
}
