package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DAY230218_BOJ1515_수이어쓰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int n = 1;

        int pos = 0;
        outer:
        while (true) {
            String tmp = String.valueOf(n);
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == str.charAt(pos)) {
                    pos++;
                }
                if (pos == str.length()) break outer;
            }
            n++;
        }
        System.out.println(n);
    }
}
