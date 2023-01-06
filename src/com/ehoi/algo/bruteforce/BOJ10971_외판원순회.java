package com.ehoi.algo.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10971_외판원순회 {
    static int n;
    static int[][] map;
    static boolean[] visited;
    static int start;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n과 비용 맵 입력받기, 그리고 배열들 초기화
        n = Integer.parseInt(st.nextToken());
//        visited = new boolean[n];
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 끝

        // 포문 돌면서 i를 출발시킬 건데, static 변수에 i 저장
        for (int i = 0; i < n; i++) {
            visited = new boolean[n]; // 실수 : 출발지를 달리 할때마다 매번 새로 초기화되어야 한다.
            start = i;
            visited[i] = true;
//            recur(i, 0, 0);
            recur(i, 1, 0); // 실수 : cnt를 1로 했어야 했다. 이미 여기서 출발하면서 1군데 들렸으니까
        }
        // => 근데 중요한 건 꼭 출발지를 모두 다 돌 필요가 없다는 것
        // 1 - 2 - 3 - 4가 정답이라면 2-3-4-1, 3-4-1-2. 4-1-2-3 모두 같은 결과일테니까!

        System.out.println(ans);
        br.close();
    }

    private static void recur(int curr, int cnt, int cost) {
        // 현재까지의 비용이 정답보다 이미 크다면? 백트래킹
        if (cost > ans) return;

        // 베이스 부분
        // 모두 다 들렀고, 현재 있는 곳에서 출발지로 갈 수 있다면?
        // 정답과 cost 최솟값 비교
        if (cnt == n && map[curr][start] != 0) {
//            ans = Math.min(ans, cost);
            ans = Math.min(ans, cost + map[curr][start]); // 실수 : 마지막 도시에서 출발한 도시로 간다면 그 비용까지 더했어야 했다!
            return;
        }

        // 재귀
        // 중복불가한 순열
        for (int to = 0; to < n; to++) {
            // 방문검사
            // 갈수 있는 길인지 검사
            // 갈수 있따면 재귀 던지기
            if (visited[to]) continue;
            if (map[curr][to] == 0) continue;
            visited[to] = true; // 실수 : 방문처리를 하지 않았다
            recur(to, cnt + 1, cost + map[curr][to]);
            visited[to] = false;
        }
    }
}
