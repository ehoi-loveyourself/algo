package com.ehoi.algo;

public class DAY230203_PRO_최소직사각형 {
    public int solution(int[][] sizes) {
        int answer = 0;
        // 가로를 세로보다 긴 걸로 재정렬
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }

        // 가로 최대 길이, 세로 최대 길이를 구하자
        int maxWidth = 0;
        int maxHeight = 0;
        for (int i = 0; i < sizes.length; i++) {
            maxWidth = Math.max(maxWidth, sizes[i][0]);
            maxHeight = Math.max(maxHeight, sizes[i][1]);
        }

        return maxWidth * maxHeight;
    }
}
