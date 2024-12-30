package com.ehoi.algo.dfs_bfs;

import java.io.*;
import java.util.*;

public class BOJ2660_회장뽑기 {

    static int cnt;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        cnt = Integer.parseInt(st.nextToken());
        list = new ArrayList[cnt + 1];
        for (int i = 1; i <= cnt; i++) {
            list[i] = new ArrayList<>();
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) break;

            list[a].add(b);
            list[b].add(a);
        }

        int[] ans = new int[cnt + 1];
        for (int i = 1; i <= cnt; i++) {
            ans[i] = bfs(i);
        }

        // 가장 최소 점수는 얼말까?
        int minScore = 50;
        int minCnt = 0;
        for (int i = 1; i <= cnt; i++) {
            if (ans[i] < minScore) {
                minScore = ans[i];
                minCnt = 1;
            } else if (ans[i] == minScore) {
                minCnt++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(minScore).append(" ").append(minCnt).append("\n");

        for (int i = 1; i <= cnt; i++) {
            if (ans[i] == minScore) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static int bfs(int n) {
        boolean[] visited = new boolean[cnt + 1];

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(n, 0));
        visited[n] = true;

        int maxScore = 0;
        while (!queue.isEmpty()) {
            Pos curr = queue.poll();
            int friend = curr.friend;
            int score = curr.score;

            for (int f : list[friend]) {
                if (visited[f]) continue;
                visited[f] = true;
                queue.add(new Pos(f, score + 1));
                maxScore = Math.max(maxScore, score + 1);
            }
        }
        return maxScore;
    }

    static class Pos {
        int friend;
        int score;

        public Pos(int friend, int score) {
            this.friend = friend;
            this.score = score;
        }
    }
}