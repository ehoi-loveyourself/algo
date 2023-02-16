package com.ehoi.algo;

import java.io.*;
import java.util.*;

// 1. 첫번째는 시작점과 도착점이 같은 경우를 놓쳐서
// 2. 두번째는 시간초과 : 경로를 매번 저장하려고 해서 났다.
// 3. 해결 : 자신의 이전 위치를 저장하는 배열을 만들었다.
public class DAY230216_BOJ13913_숨바꼭질4 {
    static int[] spot = new int[100_001]; // 해당 스팟에 몇 초만에 가는지
    static int[] parent = new int[100_001]; // 어느 노드로부터 왔는지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 언니가 있는 자리
        int k = Integer.parseInt(st.nextToken()); // 동생이 있는 자리
        Arrays.fill(spot, -1);
        Arrays.fill(parent, -1);

        // 시작점이랑 도착점이 같을 때 경로릉 출력해 주어야 하는 데 그것을 하지 않아서 틀렸다.
//        if (n == k) System.out.println(0);
//        else
        bfs(n, k);

        // 도착지부터 거꾸로 출력할테니까 스택에 넣어서 꺼내자
        Stack<Integer> stack = new Stack<>();
        int idx = k;

        while (idx != -1) { // 출발점에 도착할 때까지
            stack.push(idx);
            idx = parent[idx];
        }
        sb.append(spot[k]).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        spot[n] = 0; // 0초에 여기 있어용
        // n은 시작점이니까 -1로 그대로 두기

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr == k) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) next = curr - 1;
                else if (i == 1) next = curr + 1;
                else next = curr * 2;

                /* 이 부분 처리를 해주는 것이 굉장히 중요한 부분이어따!!! */
                // 이동한 위치가 갈 수가 없는 위치면
                if (next < 0 || next > 100_000) continue;
                // 이미 그 위치에 그 전에 왔었다면?
                if (spot[next] != -1) continue;

                spot[next] = spot[curr] + 1;
                parent[next] = curr;
                q.add(next);
            }
        }
    }

    /*
    private static class Spot {
        private int pos;
        private String path;

        public Spot(int pos, String path) {
            this.pos = pos;
            this.path = path;
        }
    }
     */
}
