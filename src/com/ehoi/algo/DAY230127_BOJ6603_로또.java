package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DAY230127_BOJ6603_로또 {
    static int k;
    static int[] S;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] tmp = br.readLine().split(" ");
            k = Integer.parseInt(tmp[0]);
            if (k == 0) break;
            S = new int[k];
            visited = new boolean[k];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(tmp[i + 1]);
            }
            recur(0, 0);
            System.out.println();
        }
        br.close();
    }

    private static void recur(int idx, int cnt) {
        // 종료 조건 : 6개 다 뽑았으면 출력하기
        if (cnt == 6) {
            for (int i = 0; i < k; i++) {
                if (visited[i])
                    System.out.printf("%d ", S[i]);
            }
            System.out.println();
            return;
        }

        // 재귀 : 방문하지 않았다면 방문했다가 방문처리 풀기
        for (int i = idx; i < k; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            recur(i + 1, cnt + 1);
            visited[i] = false;
        }
    }
}
