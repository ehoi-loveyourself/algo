package com.ehoi.algo.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ7562_나이트의이동 {
    static int I;
    static int[] target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            I = Integer.parseInt(br.readLine()); // 한 변의 길이
            String[] currS = br.readLine().split(" ");
            int[] curr = new int[] {Integer.parseInt(currS[0]), Integer.parseInt(currS[1])};

            String[] targetS = br.readLine().split(" ");
            target = new int[] {Integer.parseInt(targetS[0]), Integer.parseInt(targetS[1])};

            sb.append(bfs(curr[0], curr[1])).append("\n");
        }
        System.out.println(sb);
    }

    static int[] dr = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] dc = {-1, 1, 2, 2, 1, -1, -2, -2};

    private static int bfs(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        int[][] map = new int[I][I]; // 최단거리 저장 배열
        for (int i = 0; i < I; i++) {
            Arrays.fill(map[i], -1);
        }
        queue.add(new Node(r, c, 0));
        map[r][c] = 0;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            // 현재 위치가 타겟 위치면 지금까지 이동한 위치 cnt가 정답
            if (curr.r == target[0] && curr.c == target[1]) {
                return curr.cnt;
            }

            // 그게 아니면 계속 이동
            // 8방 탐색
            for (int d = 0; d < 8; d++) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                // 범위 안에 있는지
                if (!canGo(nr, nc)) continue;
                if (map[nr][nc] == -1) {
                    map[nr][nc] = curr.cnt + 1;
                    queue.add(new Node(nr, nc, curr.cnt + 1));
                }
            }
        }

        return 0;
    }

    static boolean canGo(int r, int c) {
        return 0 <= r && r < I && 0 <= c && c < I;
    }

    static class Node {
        int r, c, cnt;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}