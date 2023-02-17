package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나는 이분탐색의 범위를 left를 (총 예산 / 도시 수) 즉, 평균 예산으로
// right 를 도시 중 최고 예산을 요구하는 곳으로 잡았지만
// 굳이 코드를 더 작성할 필요 없이
// left 값을 가장 예산을 적게 요구하는 곳으로 잡고 돌렸어도 간편했을 뻔 했다!
public class DAY230217_BOJ2512_예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 도시의 개수
        int[] city = new int[n];
        long max = 0;
        long totalNeeded = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cityBudget = Integer.parseInt(st.nextToken());
            max = Math.max(max, cityBudget);
            city[i] = cityBudget;
            totalNeeded += cityBudget;
        }

        long totalBudget = Long.parseLong(br.readLine()); // 총 예산

        if (totalNeeded <= totalBudget) {
            System.out.println(max);
            System.exit(0);
        }

        long avgBudget = totalBudget / n; // 평균 예산
        long left = avgBudget; // 얘가 정답의 최소 범위가 됨
        long right = max;

        long gap = right - left;
        long ans = 0;
        while (left <= right) {
            long mid = (left + right) / 2;

            long sum = 0;
            for (int money : city) {
                sum += Math.min(mid, money);
            }
            if (sum > totalBudget) {
                right = mid - 1;
            } else {
                // 총 예산보다 적게 든다면 그 중에서는 값이 최고여야 해
                left = mid + 1;
                ans = Math.max(ans, mid);
            }
        }
        System.out.println(ans);
    }
}
