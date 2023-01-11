package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec32_선택정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        } // 입력 끝

        // i 의 용도 : 최솟값의 인덱스 j를 선택해서 swap할 위치! i부터 n - 2까지만 그 기준점을 잡으면 된다.
        // j 의 용도 : 기준점이 되는 i 뒤부터 배열 끝까지 돌면서 최솟값을 찾기 위한 idx 역할을 한다. (i + 1 ~ n - 1)
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = tmp;
        }
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        sc.close();
    }
}

/**
 * 장점 : 추가적인 메모리 소비가 작다.
 * 단점 : 시간 복잡도가 O(N^2)이다. + 안정 정렬이 아니다.
 */
