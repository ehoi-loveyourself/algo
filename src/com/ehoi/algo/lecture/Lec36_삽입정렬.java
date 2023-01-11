package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec36_삽입정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        insert_sort(arr, arr.length);

        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        sc.close();
    }

    /**
     * 삽입정렬의 큰 틀
     * 정렬되지 않은 배열에서 최솟값을 찾아서 현재 idx가 가리키고 있는 곳과 swap 한다
     *
     * 라운드 = 총 횟수 : size - 1 번
     * 매 라운드마다 비교 범위 : 현재 정렬되어야 할 idx부터 끝까지
     */
    private static void insert_sort(int[] arr, int size) {
        for (int i = 0; i < size - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            // 최솟값을 가리키는 idx를 찾았으니 swap
            int tmp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = tmp;
        }
    }
}
