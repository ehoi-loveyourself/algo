package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec18_층간소음 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M 을 입력받는다.
        // cnt와 max 변수
        int N = sc.nextInt();
        int M = sc.nextInt();
        int cnt = 0, max = 0;

        // 반복을 돌면서
        // M을 초과할 때마다 cnt를 ++한다
        // 초과하지 않으면 cnt와 max를 비교해서 max를 갱신하고 cnt를 0으로 초기화한다.
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num >= M) {
                cnt++;
                if (cnt > max) {
                    max = cnt;
                }
            } else {
                cnt = 0;
            }
        }

        // 다 돌고 마지막에 나와서 max를 출력한다.
        // 경보음이 없었으면 -1 출력
        if (max == 0) System.out.println(-1);
        else System.out.println(max);
    }
}
