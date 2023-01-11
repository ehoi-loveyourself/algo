package com.ehoi.algo.lecture;

import java.util.*;

public class Lec34_버블정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        bubble_sort(arr, arr.length);

        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        sc.close();
    }

    private static void bubble_sort(int[] arr, int size) {
        // 라운드 (횟수)를 돈다. => 배열 크기 - 1 만큼
        for (int i = 1; i < size; i++) {
            // 각 라운드마다 비교할 idx는 0 부터 size - 각 라운드(i) 임
            for (int j = 0; j < size - i; j++) {
                // 오름차순이라면 내가 내 뒤에 애보다 크다면 swap
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1, arr);
                }
            }
        }
    }

    private static void swap(int a, int b, int[] arr) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}

/**
 * 장점
 * 1. 추가적인 메모리 소비가 적다
 * 2. 안정 정렬이 가능하다.
 * 3. 구현이 쉽다.
 *
 * 단점
 * 1. 다른 정렬 알고리즘에 비해 교환 과정이 많아 시간이 많이 소비된다.
 */
