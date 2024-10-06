package com.ehoi.algo.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966_프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken()); // 테스트 케이스
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 몇 번째로 인쇄되었는지 궁금한 문서가 현재 위치한 자리

            Queue<int []> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                queue.add(new int[]{i, Integer.parseInt(st.nextToken())});
            } // 입력 완료

            // 맨 앞에 있는 걸 뽑는다.
            // 얘가 큐 전체에서 중요도가 제일 높은지 확인한다.

            // 제일 중요도가 높으면 1) 첫번째로 뽑는 거니까 cnt++ 2) q.poll한다. 3) 근데 그 자리가 M이면 그 cnt를 sb에 담고 걍 끝낸다.
            // 중요한 애가 아니면 다시 큐에 넣는다.

            int cnt = 0;
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                boolean prior = true; // 내가 제일 높아!

                for (int[] q : queue) {
                    if (poll[1] < q[1]) { // 더 중요한 게 있으면
                        prior = false;
                        break;
                    }
                }

                if (prior) {
                    cnt++;
                    if (poll[0] == M) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                } else {
                    queue.add(poll);
                }
            }
        }
        System.out.println(sb);
    }
}