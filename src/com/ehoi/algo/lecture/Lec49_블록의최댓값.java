package com.ehoi.algo.lecture;

import java.util.Arrays;
import java.util.Scanner;

public class Lec49_블록의최댓값 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        int[] front = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            front[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            right[i] = sc.nextInt();
        } // 입력 끝

        // 1. 정면에서 본 만큼 블록을 세워보자
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                map[i][j] = front[j];
            }
        }

        // 2. 오른쪽에서 본 대로 정리하자
        for (int i = 0; i < n; i++) {
            int pivot = right[i];
            for (int j = n - 1; j >= 0; j--) {
                if (map[i][j] > pivot) {
                    map[i][j] = pivot;
                }
            }
        }
        System.out.println(Arrays.deepToString(map));

        // 3. 이제 개수 세자
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt += map[i][j];
            }
        }
        System.out.println(cnt);

        sc.close();
    }
}
