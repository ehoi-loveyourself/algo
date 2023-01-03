package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec20_가위바위보 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            int res = map[0][i] - map[1][i];
            if (res == 1 || res == -2) System.out.println("A");
            else if (res == -1 || res == 2) System.out.println("B");
            else System.out.println("D");
        }
        sc.close();
    }
}
