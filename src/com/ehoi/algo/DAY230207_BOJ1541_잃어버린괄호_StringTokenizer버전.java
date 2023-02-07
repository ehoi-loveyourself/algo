package com.ehoi.algo;

import java.io.*;
import java.util.*;

public class DAY230207_BOJ1541_잃어버린괄호_StringTokenizer버전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-"); // '-'를 기준으로 문자열을 자른다

        int ans = Integer.MAX_VALUE;
        while (st.hasMoreTokens()) {
            // 잘린 문자열을 +를 기준으로 또 자른다
            StringTokenizer sub = new StringTokenizer(st.nextToken(), "+");

            int subSum = 0;
            while (sub.hasMoreTokens()) {
                subSum += Integer.parseInt(sub.nextToken());
            }

            // 전체의 첫번째 토큰이었다면 더하고, 그 뒤의 토큰이었다면 빼줘야 하는데
            // 이를 확인하는 방법은 정답값을 가지고 판별할 것이다.
            // 미리 정답값을 임의의 수로 잡고, 현재 그 값이 임의의 수인지 변화가 있었는지를 감지해서 구분하면 된다.
            // 정답에 영향을 주지 않는 임의의 수는 정수의 최댓값이나 최솟값 등으로 하는 것이 좋을 것 같다.
            if (ans == Integer.MAX_VALUE) { // 여전히 초기 값이라면
                ans = subSum; // 이 값으로 변경해주기
            } else { // 초기 값이 이미 있다면
                ans -= subSum;
            }
        }

        System.out.println(ans);
    }
}
