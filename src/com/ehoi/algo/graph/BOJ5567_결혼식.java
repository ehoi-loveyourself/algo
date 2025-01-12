package com.ehoi.algo.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ5567_결혼식 {
    static List<Integer>[] friends;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 동기 수
        int M = Integer.parseInt(br.readLine()); // 친구관계 수

        friends = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            friends[i] = new ArrayList<>();
        } // 초기화

        for (int i = 0; i < M; i++) {
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);

            friends[a].add(b);
            friends[b].add(a);
        }

        System.out.println(bfs(1));
    }

    static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>(); // 친구 depth까지 표시할 예정
        boolean[] visited = new boolean[N + 1];

        queue.add(new int[]{start, 0}); // 상근이부터 넣기
        visited[start] = true;

        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int depth = poll[1];

            if (depth >= 2) continue; // 2보다 큰 애들은 안 넣을거니까

            for (int friend : friends[poll[0]]) {
                if (visited[friend]) continue;
                visited[friend] = true;
                cnt++;
                queue.add(new int[]{friend, depth + 1});
            }
        }

        return cnt;
    }
}