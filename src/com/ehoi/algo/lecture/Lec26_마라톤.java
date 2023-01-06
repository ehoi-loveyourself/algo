package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec26_마라톤 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
//        int[] ans = new int[n];

        System.out.print("1 ");
        for (int i = 1; i < n; i++) {
            int tmp = i;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) tmp--;
            }
            System.out.printf("%d ", tmp + 1);
        }

//        for (int i : ans) {
//            System.out.printf("%d ", i + 1);
//        }
        sc.close();
    }
}
