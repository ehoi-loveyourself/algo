package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec19_분노유발자_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = arr[n - 1];
        int cnt = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                cnt++;
                max = arr[i];
            }
        }
        System.out.println(cnt);
    }
}
