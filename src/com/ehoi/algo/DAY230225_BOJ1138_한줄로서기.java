package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DAY230225_BOJ1138_한줄로서기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
        제일 키 큰 애(n-1)부터 = 뒤에서부터 -> 사실 얘는 무조건 0이라서
        그 다음 애(n-2)가 0이면 맨 앞에 서는 거고
        1이면 키 큰애 idx 뒤에 서는 거고

        그 다음에(n-3)애의 범위는 0 - 2까지가 가능하지
        0이면 맨 앞에
        1이면 일등으로 서 있는애 뒤에 넣고
        2이면 2등으로 서 있는애 뒤에 넣고

        ... 이런식으로 반복하면 되는데

        이거를 어떻게 중간에 삽입하느냐가 문제야!
        어차피 배열크기가 10이니까 계속 뒤로 미뤄주면서 넣으면 되나
         */
        int n = Integer.parseInt(st.nextToken()); // 사람 수

        int[] arr = new int[n]; // 정보
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int num = arr[i];
            for (int j = n - 2; j >= num; j--) {
                ans[j + 1] = ans[j];
            }
            ans[num] = i;
        }

        for (int num : ans) {
            System.out.printf("%d ", num + 1);
        }
    }
}
