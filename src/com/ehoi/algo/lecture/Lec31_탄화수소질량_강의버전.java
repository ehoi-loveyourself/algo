package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec31_탄화수소질량_강의버전 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        int c = 0;
        int h = 0;
        int pos; // H의 위치가 될 자리
        if (arr[1] == 'H') {
            c = 1;
            pos = 1;
        } else {
            // H가 나올때까지 숫자를 더하자
            int i;
            for (i = 1; i != 'H'; i++) {
                c = c * 10 + arr[i] - '0';
            }
            pos = i; // H의 위치
        }

        if (arr[pos + 1] == '\0') h = 1;
        else {
            for (int i = pos + 1; i != '\0'; i++) {
                h = h * 10 + arr[i] - '0';
            }
        }
        System.out.println(c * 12 + h);
        sc.close();
    }
}
