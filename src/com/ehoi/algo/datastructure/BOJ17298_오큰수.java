package com.ehoi.algo.datastructure;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N을 입력받고 배열을 만들어서 수열을 입력받는다.
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 2. 이중 포문을 돌면서 각각의 오큰수를 구한다.
        StringBuilder sb = new StringBuilder();
        out: for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] < arr[j]) {
                    sb.append(arr[j]).append(" ");
                    continue out;
                }
            }
            sb.append(-1).append(" ");
        }
        // 3. 출력한다.
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
