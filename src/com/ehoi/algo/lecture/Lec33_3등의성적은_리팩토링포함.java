package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec33_3등의성적은_리팩토링포함 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        } // 입력 끝

        // 선택정렬 내림차순으로
        selection_sort(arr, arr.length);

        /**
         * 내가 풀이한 버전
        // 3등 찾기
        int score = arr[0];
        int cnt = 1; // 등수
        int i = 1;
        while (true) {
            if (cnt == 3) {
                break;
            }
            if (i == n) {
                score = -1;
                break;
            }
            if (score != arr[i]) {
                cnt++; // 등수 달라지고
                score = arr[i]; // 기준 점수도 달라지고
            }
            i++;
        }
         */

        /**
         * 강의 버전
         */
        int cnt = 0;
        int score = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                cnt++;
            }
            if (cnt == 2) {
                score = arr[i];
                break;
            }
        }

        // 점수 출력
        System.out.println(score);
        sc.close();
    }

    private static void selection_sort(int[] arr, int size) {
        for (int i = 0; i < size - 1; i++) {
            int max_idx = i;
            for (int j = i; j < size; j++) {
                if (arr[j] > arr[max_idx]) {
                    max_idx = j;
                }
            }
            swap(i, max_idx, arr);
        }
    }

    private static void swap(int a, int b, int[] arr) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
