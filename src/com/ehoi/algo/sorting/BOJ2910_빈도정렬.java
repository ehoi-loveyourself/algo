package com.ehoi.algo.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2910_빈도정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        List<Integer> origin = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            origin.add(num);
            sorted.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        } // 입력 완료

        Collections.sort(sorted, (o1, o2) -> {
            // 빈도수가 같으면
            if (Objects.equals(map.get(o1), map.get(o2))) {
                return origin.indexOf(o1) - origin.indexOf(o2);
            } else {
                return map.get(o2) - map.get(o1);
            }
        }); // 정렬 완료

        for (int num : sorted) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}