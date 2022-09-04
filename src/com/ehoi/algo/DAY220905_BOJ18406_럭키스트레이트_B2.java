package com.ehoi.algo;

import java.util.Scanner;

public class DAY220905_BOJ18406_럭키스트레이트_B2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 점수를 문자열로 받기
        String score = sc.next();
        int length = score.length() / 2;
        String front = score.substring(0, length);
        String rear = score.substring(length);

        int frontSum = getSum(front);
        int rearSum = getSum(rear);

        String ans = "READY";
        if (frontSum == rearSum) {
            ans = "LUCKY";
        }
        System.out.println(ans);
    }

    private static int getSum(String subString) {
        int num = 0;
        for (int i = 0; i < subString.length(); i++) {
            num += subString.charAt(i) - '0';
        }
        return num;
    }
}
