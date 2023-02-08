package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class DAY230208_BOJ2628_종이자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        List<Integer> wList = new ArrayList<>();
        List<Integer> hList = new ArrayList<>();

        /* 이 리스트에 0과 가로 세로의 길이도 미리 넣어둔다면 깔끔하다 */
        wList.add(0);
        wList.add(w);
        hList.add(0);
        hList.add(h);
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int comm = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            if (comm == 0) {
                hList.add(len);
            } else {
                wList.add(len);
            }
        }

        // 정렬
        Collections.sort(wList);
        Collections.sort(hList);

        // 가로의 최대길이를 구하자
        int wMax = getMaxLength(wList);
        int hMax = getMaxLength(hList);

        System.out.println(wMax * hMax);
    }

    private static int getMaxLength(List<Integer> list) {
        int max = 0;
        for (int i = 1; i < list.size(); i++) {
            max = Math.max(list.get(i) - list.get(i - 1), max);
        }
        return max;
    }
}
