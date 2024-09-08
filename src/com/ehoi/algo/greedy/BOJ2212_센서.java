package com.ehoi.algo.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2212_센서 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 센서 개수
        int n = Integer.parseInt(st.nextToken());

        // 집중국 개수
        int k = Integer.parseInt(br.readLine());

        if (k >= n) System.out.println(0);
        else {
            // 센서 배열
            int[] sensors = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                sensors[i] = Integer.parseInt(st.nextToken());
            }
            // 순서대로 정렬
            Arrays.sort(sensors);

            int totalLength = 0;
            List<Integer> diff = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                int diffLength = sensors[i + 1] - sensors[i];
                totalLength += diffLength;
                diff.add(diffLength);
            }
            // 거리가 긴 것부터 내림차순 정렬
            diff.sort(Comparator.reverseOrder());

            for (int i = 0; i < k - 1; i++) {
                totalLength -= diff.get(i);
            }

            System.out.println(totalLength);
        }
    }
}