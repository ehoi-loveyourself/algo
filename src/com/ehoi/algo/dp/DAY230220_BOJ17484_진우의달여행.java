package com.ehoi.algo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DAY230220_BOJ17484_진우의달여행 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 완료

        int[][][] dp = new int[n][m][3];
        // 출발 지점 초기화해주기
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < 3; k++) {
                dp[0][j][k] = map[0][j];
            }
        }
        // 그리고 가장 왼쪽과 가장 오른쪽은 초기화
        dp[0][0][0] = dp[0][m - 1][2] = Integer.MAX_VALUE;
        // 나머지는 모두 최댓값으로 초기화
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    if (k == 0) {
                        // 왼쪽 위에서 오는 거
                        // 왼쪽이 있는지부터 확인
                        if (j - 1 < 0) continue;
                        dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + map[i][j];
                    } else if (k == 1) {
                        // 내 위에서 오는 거
                        dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + map[i][j];
                    } else {
                        // 오른쪽 위에서 오는거
                        // 오른쪽 위가 있는지 확인
                        if (j + 1 >= m) continue;
                        dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + map[i][j];
                    }
                }
            }
        }

        // 마지막 행에서 최솟값을 찾자
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < 3; k++) {
                ans = Math.min(ans, dp[n - 1][j][k]);
            }
        }
        System.out.println(ans);
        br.close();
    }
}
