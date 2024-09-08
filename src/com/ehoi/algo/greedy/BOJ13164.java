package com.ehoi.algo.greedy;

import java.util.*;

/* 풀이 포인트
        키 차이만큼이 단체티를 맞추는 비용
        키 차이가 N-1개 있을 텐데 가장 크게 차이 나는 것 K-1를 골라서 빼고
        나머지를 더하면 됨
         */
public class BOJ13164 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        // 1. 키 입력 받기
        List<Integer> tall = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tall.add(sc.nextInt());
        }

        // 2. 키 차이를 계산해서 키 순서대로 정렬해보자
        // 2-1. 티셔츠 비용도 이때 다 더해주자
        int totalCost = 0;
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int cost = tall.get(i + 1) - tall.get(i);
            totalCost += cost;
            diff.add(cost);
        }
        // 내림차순 정렬
        diff.sort(Collections.reverseOrder());

        // 3. k-1개만큼 티셔츠 비용에서 빼기
        for (int i = 0; i < k - 1; i++) {
            totalCost -= diff.get(i);
        }

        System.out.println(totalCost);
    }
}