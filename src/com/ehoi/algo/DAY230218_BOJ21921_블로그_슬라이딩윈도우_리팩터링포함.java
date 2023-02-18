package com.ehoi.algo;

import java.io.*;
import java.util.*;

public class DAY230218_BOJ21921_블로그_슬라이딩윈도우_리팩터링포함 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 블로그를 한 일수
        int x = Integer.parseInt(st.nextToken()); // 구하고 싶은 기간

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 일일 방문자 수
        }

        int sum = 0;
        int max = 0;
        int cnt = 1;
        // 포문을 두번 돌지 않고 한번에 해결하는 방법이 있다.
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (i == x - 1) { // x-1는 기준점이 될 첫 기간의 합의 마지막 인덱스이므로
                max = sum; // 이 값을 max에 넣어둔다.
            }

            if (i > x - 1) { // 그 이후에는 기간에서 벗어난 값을 빼준다.
                sum -= arr[i - x];
            }

            if (sum > max) {
                max = sum;
                cnt = 1; // 최고 방문자수가 바뀌었으므로 cnt는 1로 초기화해준다.
            } else if (sum == max) {
                cnt++;
            }
        }

        /*
        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum += arr[i]; // 일단 기준이 될 첫 기간(0 ~ (x-1))의 방문자 수의 합을 구함
        }

        int cnt = 1;
        int max = sum;
        for (int i = x; i < arr.length; i++) {
            sum = sum + arr[i] - arr[i - x]; // x일의 방문자수를 더하고 0일의 방문자수를 뺀다
            if (sum > max) {
                max = sum;
                cnt = 1; // 새로운 방문자수가 나오면 연속일수 1로 갱신해줘야지!
            } else if (sum == max) {
                cnt++; // 최고 방문자수를 유지하고 있다면 연속일을 ++해주자
            }
        }
         */

        if (max == 0) bw.write("SAD\n");
        else {
            bw.write(String.valueOf(max) + "\n");
            bw.write(String.valueOf(cnt) + "\n");
        }
        bw.close();
        br.close();
    }
}
