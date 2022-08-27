package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DAY220827_BOJ2231_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            int number = i;
            int sum = number;

            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }

            if (sum == N) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}


