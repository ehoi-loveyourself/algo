package com.ehoi.algo.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795_먹을것인가먹힐것인가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 0; tc < T; tc++) {
            // 각 테스트 케이스의 첫째 줄에는 A의 수 N과 B의 수 M이 주어진다.
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            // 둘째 줄에는 A의 크기가 모두 주어지며, 셋째 줄에는 B의 크기가 모두 주어진다. 크기는 양의 정수이다. (1 ≤ N, M ≤ 20,000)
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            // 먹힐 물고기 집단 B를 정렬
            Arrays.sort(B);
            // B의 최솟값과 최댓값을 찾아두자
            int minB = B[0];
            int maxB = B[B.length - 1];

            int ans = 0;
            // 물고기 A마리수 만큼 비교
            for (int i = 0; i < N; i++) {
                // 만약에 A[i] 물고기가 maxB보다 크면 난 여기 있는 거 다 먹을 수 있어
                if (A[i] > maxB) {
                    ans += B.length;
                    continue;
                }

                // 만약 최소크기 물고기 보다 작으면 아무것도 못 먹으니까 더 보지 마
                if (A[i] <= minB) {
                    continue;
                }

                int left = 0;
                int right = B.length - 1;

                int howMany = 0;
                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (A[i] > B[mid]) { // B를 먹을 수 있으면
                        left = mid + 1; // 더 큰 걸 먹을 수 있는지 가보자
                        howMany = mid + 1; // 나는 지금 이만큼은 먹을 수 있어
                    } else {
                        right = mid - 1; // 더 작은 물고기 찾으러 가
                    }
                }
                ans += howMany;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}