package com.ehoi.algo.bruteforce;

import java.util.*;

public class BOJ6064_카잉달력_Me {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int X = sc.nextInt();
            int Y = sc.nextInt();

            int n = 1, x = 1, y = 1, ans = -1;

            while (true) {
                if (X == x && Y == y) {
                    ans = n;
                    break;
                }
                if (x == M && y == N) {
                    break;
                }
                n++; x++; y++;
                if (x == M + 1) x = 1;
                if (y == N + 1) y = 1;
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
