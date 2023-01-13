package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec43_뮤직비디오_이분검색 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] len = new int[n];
//        int total = 0;
        int right = 0;
        // 추가
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            len[i] = sc.nextInt();
//            total += len[i];
            right += len[i];
            // 추가 : 곡 길이가 가장 긴 걸 찾기 위해서
            max = Math.max(max, len[i]);
        }

        int ans = 0;
        int left = 1;
//        int right = total;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 추가 : 녹음 가능한 길이가 최대 곡 길이보다 작으면 안되므로
            if (mid < max) continue;
            int sum = 0;
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                if (sum + len[i] <= mid) sum += len[i];
                else {
                    sum = len[i];
                    cnt++;
                }
            }
            if (cnt <= m) {
                right = mid - 1;
                ans = mid;
            } else left = mid + 1;
        }
        System.out.println(ans);
        sc.close();
    }
}
