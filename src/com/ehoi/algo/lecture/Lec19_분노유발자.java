package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec19_분노유발자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 학생 수
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        } // 입력 끝
        // 첫줄에 앉은 학생부터 차례대로 돌면서 내 뒤에 애들보다 내가 큰지 점검
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean tallest = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] <= arr[j]) {
                    tallest = false;
                    break;
                }
            }
            if (tallest) cnt++;
        }
        System.out.println(cnt);
    }
}
