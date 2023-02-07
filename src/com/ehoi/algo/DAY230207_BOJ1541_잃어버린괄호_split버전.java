package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DAY230207_BOJ1541_잃어버린괄호_split버전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split("-"); // '-'를 기준으로 문자열을 자른다

        int ans = 0;
        for (int i = 0; i < tokens.length; i++) {
            String[] subTokens = tokens[i].split("\\+"); // +는 정규식에서 메타문자이기 때문에 백이스케이프를 이용해야 한다

            int subSum = 0;
            for (int j = 0; j < subTokens.length; j++) {
                subSum += Integer.parseInt(subTokens[j]);
            }

            // 여기서는 첫번째 토큰인지 여부를 i 를 이용해 판단할 수 있다
            if (i == 0) {
                ans = subSum;
            } else {
                ans -= subSum;
            }
        }
        System.out.println(ans);
    }
}

// https://st-lab.tistory.com/148 참고한 블로그