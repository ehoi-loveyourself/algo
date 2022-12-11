package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec17_선생님퀴즈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 학생 수를 받는다.
        int n = sc.nextInt();
        // 2. 반복하면서 학생이 받은 카드와 정답을 받고
        // 정답인지 검증한다.
        for (int i = 0; i < n; i++) {
            int card = sc.nextInt();
            int res = sc.nextInt();
            int answer = getAnswer(card);
            if (answer == res) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static int getAnswer(int x) {
        return (1 + x) * x / 2;
    }
}
