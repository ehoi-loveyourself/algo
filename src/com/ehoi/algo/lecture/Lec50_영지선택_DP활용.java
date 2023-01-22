package com.ehoi.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lec50_영지선택_DP활용 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] map = new int[H + 1][W + 1];
        int[][] dp = new int[H + 1][W + 1];
        for (int i = 1; i <= H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + map[i][j];
            }
        }
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = N; i <= H; i++) {
            for (int j = M; j <= W; j++) {
                int sum = dp[i][j] - dp[i - N][j] - dp[i][j - M] + dp[i - N][j - M];
                ans = Math.max(ans, sum);
            }
        }
        System.out.println(ans);

        br.close();
    }
}
