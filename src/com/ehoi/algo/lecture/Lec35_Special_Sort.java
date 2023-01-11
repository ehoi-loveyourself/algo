package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec35_Special_Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > 0 && arr[j + 1] < 0) {
                    swap(j, j + 1, arr);
                }
            }
        }

        for (int i : arr) {
            System.out.printf("%d ", i);
        }

        sc.close();
    }

    private static void swap(int a, int b, int[] arr) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}

/**
 * 버블 정렬이 안정 정렬이라는 것을 이용하는 것이 포인트!
 */