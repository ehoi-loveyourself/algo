package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DAY230210_BOJ2292_벌집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int d = 0;
        int cnt = 1;
        while (true) {
            if (n > 1 + 6 * d) {
                d += cnt;
                cnt++;
            } else {
                System.out.println(cnt);
                break;
            }
        }
    }
}
