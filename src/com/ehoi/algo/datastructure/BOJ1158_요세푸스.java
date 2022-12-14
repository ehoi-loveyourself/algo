package com.ehoi.algo.datastructure;

import java.io.*;
import java.util.*;

public class BOJ1158_요세푸스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 입력받기
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 2. 큐에 N까지 넣기
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // 3. 큐가 빌때까지 k의 조건이 맞으면 꺼내서 출력하고
        // 아니면 다시 큐에 넣고 반복
        // 출력하고도 큐가 비지 않았으면 , 붙여주기
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int cnt = 1;
        while (!queue.isEmpty()) {
            if (cnt != K) {
                queue.add(queue.poll());
                cnt++;
            } else {
                sb.append(queue.poll());
                if (queue.size() != 0) sb.append(", ");
                cnt = 1;
            }
        }
        sb.append(">");
        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
