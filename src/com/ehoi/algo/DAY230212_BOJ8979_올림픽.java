package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY230212_BOJ8979_올림픽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 1][4];
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= 3; j++) {
                map[idx][j] = Integer.parseInt(st.nextToken());
            }
        }

        // m을 기준으로 비교한다.
        visited[m] = true; // 나 자신은 비교대상이 아니니까 미리 넣어두기
        int ans = 1; // 일단 내가 일등

        // 금 은 동 순서로 비교하자
        for (int j = 1; j <= 3; j++) {
            int curr = map[m][j];

            for (int i = 1; i <= n; i++) {
                // 이미 비교했던 국가는 빼고
                if (visited[i]) continue;
                // 나보다 메달 수가 많으면
                if (curr < map[i][j]) {
                    ans++; // 등수 밀려나고
                    visited[i] = true; // 비교했으니까 바이
                } else if (curr > map[i][j]) {
                    // 나보다 메달 수가 적으면 아예 앞으로도 볼 필요가 없으니까 바이
                    visited[i] = true;
                }
            }
        }
        System.out.println(ans);
    }
}
