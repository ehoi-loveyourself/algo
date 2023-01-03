package com.ehoi.algo.bruteforce;

import java.util.*;
import java.io.*;

public class BOJ14889_스타트와링크 {
    static int n;
    static int[][] map;
    static boolean[] visited; // 비중복 조합용
    static int ans = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 끝

        // 팀 구하러 재귀 던지기
        recur(0, 0);
        // 정답 출력
        System.out.println(ans);
        br.close();
    }

    private static void recur(int start, int cnt) {
        // 베이스 : cnt가 n/2라면
        if (cnt == n/2) {
            // 선택된 팀과
            // 선택되지 않은 팀의 점수를 구해서
            // 그 차를 ans와 최소값 비교
            diff();
            return;
        }

        for (int i = start; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            recur(i + 1, cnt + 1);
            visited[i] = false;
        }
    }

    private static void diff() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    start += map[i][j] + map[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += map[i][j] + map[j][i];
                }
            }
        }

        int val = Math.abs(start - link);
        if (val == 0) {
            ans = 0;
            return;
        }
        ans = Math.min(ans, val);
    }
}
