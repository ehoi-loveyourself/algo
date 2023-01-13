package com.ehoi.algo.lecture;

import java.util.Arrays;
import java.util.Scanner;

public class Lec42_이분검색_강의버전 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                System.out.println(mid + 1);
                break;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        sc.close();
    }
}
