package com.ehoi.algo;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DAY230216_BOJ1697_숨바꼭질 {
    static int[] spot = new int[100_001]; // 해당 스팟에 몇 초만에 가는지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 언니가 있는 자리
        int k = Integer.parseInt(st.nextToken()); // 동생이 있는 자리
        Arrays.fill(spot, -1);

        if (n == k) System.out.println(0);
        else bfs(n, k);
        bw.close();
        br.close();
    }

    private static void bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        spot[n] = 0; // 0초에 여기 있어용

        int ans = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr == k) {
                ans = spot[curr];
                break;
            }

            for (int i = 0; i < 3; i++) {
                int next = 0;
                if (i == 0) next = curr - 1;
                else if (i == 1) next = curr + 1;
                else next = curr * 2;

                /* 이 부분 처리를 해주는 것이 굉장히 중요한 부분이어따!!! */
                // 이동한 위치가 갈 수가 없는 위치면
                if (next < 0 || next > 100_000) continue;
                // 이미 그 위치에 그 전에 왔었다면?
                if (spot[next] != -1) continue;

                spot[next] = spot[curr] + 1;
                q.add(next);
            }
        }
        System.out.println(ans);
    }
}
