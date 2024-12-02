package com.ehoi.algo.djikstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ1446_지름길 {

    static class ShortCut {
        int start, end, length;

        public ShortCut(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");

        int n = Integer.parseInt(info[0]); // 지름길의 개수
        int d = Integer.parseInt(info[1]); // 고속도로의 길이

        List<ShortCut> shortCuts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            int length = Integer.parseInt(line[2]);

            // 지름길인데 길이가 더 길면 지름길이 아님
            // 지름길인데 도착지가 고속도로를 벗어나면 그것도 안됨
            if (end <= d && (end - start) > length) {
                shortCuts.add(new ShortCut(start, end, length));
            }
        }

        // 거리 배열 초기화
        int[] dist = new int[d + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        // 고속도로를 한칸씩 전진함
        for (int i = 0; i <= d; i++) {
            // 1. 지름길이 아니라 그냥 고속도로에서 한칸 전진한다면
            // 이전 값 + 1이 거리가 됨
            if (i > 0) {
                dist[i] = Math.min(dist[i - 1] + 1, dist[i]);
            }

            // 2. 그런데 현재 위치에 지름길이 있다면 그것을 적용
            for (ShortCut sc : shortCuts) {
                if (sc.start == i) {
                    dist[sc.end] = Math.min(dist[sc.end], dist[i] + sc.length);
                }
            }
        }

        System.out.println(dist[d]);
    }
}