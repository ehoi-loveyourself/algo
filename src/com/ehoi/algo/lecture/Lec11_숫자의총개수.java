package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec11_숫자의총개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += cnt_num(i);
        }
        System.out.println(cnt);
    }

    private static int cnt_num(int x) {
        int cnt = 0;
        while (x > 0) {
            x /= 10;
            cnt++;
        }
        return cnt;
    }
}
