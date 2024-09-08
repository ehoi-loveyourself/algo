package com.ehoi.algo.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1138_한줄로서기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 사람 명수
        int[] tall = new int[n + 1]; // 0행을 빼고 입력 받으려고 한다.

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            tall[i] = Integer.parseInt(st.nextToken());
        }

        // 키가 제일 큰 사람부터 볼건데
        // 자기보다 큰 사람이 있는 수에 해당하는 자리에 넣어준다.
        List<Integer> result = new ArrayList<>();
        for (int i = n; i >= 1; i--) {
            result.add(tall[i], i); // 원래 해당 idx에 있던 애는 하나씩 뒤로 밀린다.
        }

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}