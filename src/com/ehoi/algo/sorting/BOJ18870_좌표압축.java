package com.ehoi.algo.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18870_좌표압축 {
    public static void main(String[] args) throws IOException {
        // 낮은 수가 낮은 순위를 가진다. 그러므로 오름차순 정렬을 해야 한다.
        // 같은 값일 경우에는 같은 순위를 가져야 한다. -> list 형태가 아니라 set이나 map이어야 함

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[] list = new int[N];
        int[] sorted = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list[i] = num;
            sorted[i] = num;
        } // 원 배열 저장 완료

        Arrays.sort(sorted); // 배열 정렬

        Map<Integer, Integer> map = new HashMap<>(); // 원래 값, 순위 순으로 넣기
        int prior = 0;
        int prev = Integer.MIN_VALUE; // 이전 값
        for (int j : sorted) {
            if (j > prev) {
                prev = j;
                map.put(j, prior);
                prior++;
            }
        }

        // 순위 배열 만들기 -> 만들려고 했는데 굳이 그럴필요 없이 원본 배열의 값을 key로 순위(value)를 찾으면 된다.
        for (int v : list) {
            sb.append(map.get(v)).append(" ");
        }

        System.out.println(sb);
    }
}