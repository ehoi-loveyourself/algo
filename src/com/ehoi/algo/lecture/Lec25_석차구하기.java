package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec25_석차구하기 {
    public static void main(String[] args) {
        /**
         * 뭔가 핵심을 파고드는 풀이가 있을 거라고 생각했는데
         * 간단하지만 강력한 문제였다.
         * 내 점수를 기준으로 나보다 더 높은 점수가 있다면 그냥 +1 해주면 된다.
         * 등수가 뒤로 밀린다는 거다.
         * 나는 기준과 비교대상을 비교후에 크면 어떻게 작으면 어떻게 처리를 각각 해주려고 하다가 헤맸는데
         * 오히려 더 단순하게.. 해결할 수 있었다니..
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (score[i] < score[j]) ans[i]++;
            }
        }

        for (int i : ans) {
            System.out.printf("%d ", i + 1);
        }
        sc.close();
    }
}
