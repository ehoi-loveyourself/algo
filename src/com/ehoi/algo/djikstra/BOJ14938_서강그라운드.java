package com.ehoi.algo.djikstra;

import java.io.*;
import java.util.*;

public class BOJ14938_서강그라운드 {
    static final int INF = 100000000; // 무한대 값
    static int n, m, r;
    static int[] items;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n + 1];
        dist = new int[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; // 자기 자신과의 거리는 0
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], l);
            dist[b][a] = Math.min(dist[b][a], l);
        }

        floyd();

        int maxItems = 0;
        for (int i = 1; i <= n; i++) {
            maxItems = Math.max(maxItems, getMaxItems(i));
        }

        System.out.println(maxItems);
    }

    // 플로이드-워셜 알고리즘
    static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }

    // 특정 시작 노드에서 수색 가능한 최대 아이템 개수 계산
    static int getMaxItems(int start) {
        int totalItems = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[start][i] <= m) { // 수색 범위 내
                totalItems += items[i];
            }
        }
        return totalItems;
    }
}