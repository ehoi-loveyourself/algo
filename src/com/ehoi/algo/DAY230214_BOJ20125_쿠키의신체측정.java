package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DAY230214_BOJ20125_쿠키의신체측정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 배열 크기
        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = tmp.charAt(j);
            }
        } // 입력 완료

        // 심장부터 찾자
        int heartI = 0;
        int heartJ = 0;
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '*') {
                    // 가장 윗행에서 만나게 되는 신체는 머리다
                    heartI = i + 1;
                    heartJ = j;
                    break outer; // 찾았으면 브레이크를 해야지!
                }
            }
        }

        // 심장으로부터 왼쪽! 열만 -1
        int leftArm = 1;
        int leftI = heartI;
        int leftJ = heartJ - 1;
        while (true) {
            leftJ--;
            if (leftJ < 0) break;
            if (map[leftI][leftJ] == '_') break;
            leftArm++;
        }

        int rightArm = 1;
        int rightI = heartI;
        int rightJ = heartJ + 1;
        while (true) {
            rightJ++;
            if (rightJ >= n) break;
            if (map[rightI][rightJ] == '_') break;
            rightArm++;
        }

        int waist = 1;
        int waistI = heartI + 1;
        int waistJ = heartJ;
        int finalWaistI = 0;
        while (true) {
            waistI++;
            if (map[waistI][waistJ] == '_') {
                finalWaistI = waistI - 1;
                break;
            }
            waist++;
        }

        int leftLeg = 1;
        int leftLegI = finalWaistI + 1;
        int leftLegJ = heartJ - 1;
        while (true) {
            leftLegI++;
            if (leftLegI >= n) break;
            if (map[leftLegI][leftLegJ] == '_') break;
            leftLeg++;
        }

        int rightLeg = 1;
        int rightLegI = finalWaistI + 1;
        int rightLegJ = heartJ + 1;
        while (true) {
            rightLegI++;
            if (rightLegI >= n) break;
            if (map[rightLegI][rightLegJ] == '_') break;
            rightLeg++;
        }

        // 심장 출력할 때 +1씩 더하자
        System.out.printf("%d %d\n", heartI + 1, heartJ + 1);
        System.out.printf("%d %d %d %d %d\n", leftArm, rightArm, waist, leftLeg, rightLeg);
    }
}
