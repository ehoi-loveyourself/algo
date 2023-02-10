package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DAY230210_BOJ9655_돌게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int k = n / 3;
        int l = n % 3;

        String ans = "SK";
        if (l == 0 || l == 2) {
            if (k % 2 == 0) ans = "CY";
        } else {
            if (k % 2 != 0) ans = "CY";
        }

        System.out.println(ans);
    }
}
