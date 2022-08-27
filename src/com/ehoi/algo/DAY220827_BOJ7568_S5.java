package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DAY220827_BOJ7568_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            arr[i][2] = 1;
        }

//        System.out.println(Arrays.deepToString(arr));

        // 이제 비교하기
        // i가 나고 j가 비교대상
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 나와 나를 비교하는 것은 패스
                if (i == j) continue;
                // 내가 덩치와 키 모두 작다면 등수를 키운다.
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    arr[i][2]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i][2] + " ");
        }
    }
}

