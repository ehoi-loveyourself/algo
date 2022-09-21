package com.ehoi.algo;

import java.io.*;
import java.util.*;

public class DAY220921_BOJ3190_뱀_G4 {
    static int N, K, L;
    static int[][] map;
    static Map<Integer, String> moveInfo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 맵 크기
        map = new int[N][N];

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken()); // 사과 개수
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map[a][b] = 1; // 사과 표시
        }

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken()); // 뱀의 방향 변환 횟수
        moveInfo = new HashMap<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();

            moveInfo.put(time, direction);
        }
        solve();
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int dir = 0;

    public static void solve() {
        int x = 0; // 현재 뱀의 x 좌표
        int y = 0; // 현재 뱀의 y 좌표
        int time = 0; // 0초
        Queue<Integer> q = new LinkedList<>(); // 뱀의 좌표를 담을 q : x좌표 * 100 + y좌표
        q.add(0);

        while (true) {
            time++; // 시간이 흐르고
            int nx = x + dx[dir]; // 한칸 이동한다
            int ny = y + dy[dir];

            // 게임 종료 조건부터 쳐내자
            // 1. 벽을 만났거나
            if (nx < 0 || ny < 0 || nx >= map.length || ny >= map.length) break;
            // 2. 뱀의 머리가 꼬리를 만났거나
            if (q.contains(nx * 100 + ny)) break;

            // 아니라면 이동할 수 있다!
            q.add(nx * 100 + ny);
            // 이동을 한 공간에 사과가 있다면
            if (map[nx][ny] == 1) {
                map[nx][ny] = 0; // 사과를 먹고 몸의 길이를 줄이지 않는다.
            } else {
                q.poll(); // 사과가 없다면 꼬리를 당기자
            }
            // 좌표 갱신
            x = nx;
            y = ny;

            // 다시 이동하기 전에 방향을 전환해야 하는지 체크하자
            if (moveInfo.containsKey(time)) {
                // 방향이 왼쪽이라면
                if (moveInfo.get(time).equals("L")) {
                    dir--;
                    if (dir == -1) dir = 3;
                } else {
                    dir++;
                    if (dir == 4) dir = 0;
                }
            }
        }
        System.out.println(time);
    }
}
