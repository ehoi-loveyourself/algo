package com.ehoi.algo;

import java.util.*;
import java.io.*;

public class DAY221105_BOJ_S4_숫자카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        while (st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            int i = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(i, 0)).append(" ");
        }

        System.out.println(sb.toString());
    }
}
