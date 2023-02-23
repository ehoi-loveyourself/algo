package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class DAY230223_BOJ1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                // 배열이 비어있다면 0을 출력
                if (pq.isEmpty()) System.out.println(0);
                // 배열에서 가장 작은 값을 poll
                else System.out.println(pq.poll());
            } else { // 자연수라면 x를 추가
                pq.add(x);
            }
        }
    }
}
