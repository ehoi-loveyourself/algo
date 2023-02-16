package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY230216_BOJ13305_주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 도시의 개수
        long[] len = new long[n - 1]; // 도시 사이의 거리
        long[] price = new long[n]; // 도시의 주유 가격

        st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i = 0; i < len.length; i++) {
            len[i] = Integer.parseInt(st.nextToken());
            total += len[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < price.length; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        // 주유가격 배열 조정하기
        long ans = 0;
        long minCost = price[0];
        for (int i = 0; i < len.length; i++) {
            if (minCost > price[i]) {
                minCost = price[i];
            }

            ans += minCost * len[i];
        }
        System.out.println(ans);
    }
}
