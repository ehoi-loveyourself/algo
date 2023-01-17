package com.ehoi.algo.lecture;

import java.util.*;

/**
 * 43번 문제와 똑같은 문제라고 했지만 감을 잡지 못했다!
 * 이분탐색 문제 여러번 풀면서 감을 잡자!!
 */
public class Lec44_마구간정하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] homes = new int[n];
        for (int i = 0; i < n; i++) {
            homes[i] = sc.nextInt();
        }
        Arrays.sort(homes); // 세팅 끝

        int left = 1; // 최소거리
        int right = homes[n - 1]; // 최대거리
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            // mid가 정답으로 가능한지를 탐색해보는 메서드이다.
            if (possible(mid, homes, c)) {
                left = mid + 1;
                // TODO [강조] 가능하다고 판별된 mid만 정답이 될 수 있다. else로 마무리 되어 mid가 갱신 될 수도 있으니 이 if문 안에서 갱신되어야 한다
                answer = mid;
            }
            else right = mid - 1;

        }

        System.out.println(answer);
        sc.close();
    }

    private static boolean possible(int distance, int[] homes, int c) {
        int horse = homes[0]; // 첫번째 말이 있는 위치
        int total = 1; // 배치된 말의 마리수

        for (int i = 1; i < homes.length; i++) {
            if (homes[i] - horse >= distance) { // 이 거리가 최소가 될 수 있으려면 말의 거리가 distance 보다 같거나 커야 한다
                total++; // 한 마리를 더 배치했다.
                horse = homes[i]; // 새로운 말이 위치한 곳으로 갱신
            }
        }

        return total == c; // wow
    }
}
