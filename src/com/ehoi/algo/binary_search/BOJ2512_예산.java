package com.ehoi.algo.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2512_예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫째 줄에는 지방의 수를 의미하는 정수 N이 주어진다. N은 3 이상 10,000 이하이다.
        int ctrySize = Integer.parseInt(st.nextToken());
        int[] ctryBudgets = new int[ctrySize];

        // 다음 줄에는 각 지방의 예산요청을 표현하는 N개의 정수가 빈칸을 사이에 두고 주어진다. 이 값들은 모두 1 이상 100,000 이하이다.
        st = new StringTokenizer(br.readLine());
        int totalRequestBudget = 0; // 각 도시에서 요청한 예산 전체 합
        int maxRequestBudget = 0; // 각 도시 중 요청한 예산의 최고값
        for (int i = 0; i < ctrySize; i++) {
            int requestBudget = Integer.parseInt(st.nextToken());
            ctryBudgets[i] = requestBudget;
            totalRequestBudget += requestBudget;
            maxRequestBudget = Math.max(maxRequestBudget, requestBudget);
        }

        // 그 다음 줄에는 총 예산을 나타내는 정수 M이 주어진다. M은 N 이상 1,000,000,000 이하이다.
        int totalBudget = Integer.parseInt(br.readLine());

        // 총 예산이 각 도시에서 요청한 예산의 합을 넘는다면 모두 배부 가능하므로 max를 리턴
        if (totalBudget >= totalRequestBudget) {
            System.out.println(maxRequestBudget);
            return;
        }

        // 그렇지 않다면, 총 예산내에서 줄 수 있는 최고 값을 찾아야 해
        int ans = 0;

        // 정답이 될 수 있는 범위는
        // left: 정부 예산 / 도시의 수 -> 각 도시마다 줄 수 있는 평균값
        // right: 가장 많이 요청한 도시의 예산
        int left = totalBudget / ctrySize;
        int right = maxRequestBudget;

        while (left <= right) {
            int mid = (left + right) / 2; // 정답으로 예상해보는 조정액

            int sum = 0;
            for (int budget : ctryBudgets) {
                sum += Math.min(budget, mid);
            }

            if (sum <= totalBudget) {
                left = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}