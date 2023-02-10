package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY230210_BOJ23971_ZOAC4 {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int a = h % (1 + n) == 0 ? h / (1 + n) : h / (1 + n) + 1;
        int b = w % (1 + m) == 0 ? w / (1 + m) : w / (1 + m) + 1;

        System.out.println(a * b);
    }
}
