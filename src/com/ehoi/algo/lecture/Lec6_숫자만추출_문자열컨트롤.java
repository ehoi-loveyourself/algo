package com.ehoi.algo.lecture;

import java.util.*;

public class Lec6_숫자만추출_문자열컨트롤 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
//        StringBuilder sb = new StringBuilder();
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 숫자만 다 붙여서 나오기
            if ('0' <= c && c <= '9') {
//                sb.append(c);
                ans = ans * 10 + (c - '0');
            }
        }

//        int ans = Integer.parseInt(sb.toString());

        // 약수 찾기
        int cnt = 0;
        for (int i = 1; i <= ans; i++) {
            if (ans % i == 0) cnt++;
        }

        System.out.println(ans);
        System.out.println(cnt);
    }
}
