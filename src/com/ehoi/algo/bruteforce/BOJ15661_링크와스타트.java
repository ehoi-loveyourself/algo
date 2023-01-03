package com.ehoi.algo.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15661_링크와스타트 {
    static int n;
    static int[][] map;
    static boolean[] visited;
    static int ans = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 먼저 입력을 받자
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 끝
        visited = new boolean[n];

        // 팀을 구하러 보내자
        for (int i = 1; i <= n/2; i++) {
            recur(0, i);
        }

        // 정답을 출력하자
        System.out.println(ans);
        br.close();
    }

    private static void recur(int start, int cnt) {
        if (cnt == 0) {
            // 점수 구하러 보내자
            diff();
            return;
        }

        // 한명씩 팀 선정을 해보자
        for (int i = start; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            recur(i + 1, cnt - 1);
            visited[i] = false;
        }
    }

    private static void diff() {
        // 각 팀의 점수를 초기화 하고 점수를 구하자
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

        // 각 팀의 점수의 차를 구하자
        int val = Math.abs(start - link);

        // 0이면 정답 초기화후 바로 리턴하고
        if (val == 0) {
            ans = 0;
            return;
        }
        // 아니면 최솟값 갱신하자
        ans = Math.min(ans, val);
    }
}
