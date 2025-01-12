package com.ehoi.algo.sorting;

import java.io.*;
import java.util.*;

public class BOJ2470_두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // 입력 완료

        Arrays.sort(arr); // 오름차순 정렬까지 완료

        // 양쪽 끝에 포인터를 두고 가운데 쪽으로 오자
        int left = 0;
        int right = N - 1;

        int closestZeroSum = Integer.MAX_VALUE;
        int closestLeft = N - 1;
        int closestRight = 0;

        // 교차되기 전까지만 반복
        while (left < right) {
            int sum = arr[left] + arr[right];

            // 0에 가까운 것이 정답이니까 절대값을 사용해야 한다.
            if (Math.abs(sum) < Math.abs(closestZeroSum)) {
                closestZeroSum = sum;
                closestLeft = arr[left];
                closestRight = arr[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(closestLeft + " " + closestRight);
    }
}