package com.ehoi.algo;

import java.io.*;
import java.util.*;

public class DAY230210_BOJ5073_삼각형과세변 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) break;

            // 삼각형의 조건을 만족하지 못하는 경우
            if (a + b <= c || b + c <= a || c + a <= b) {
                System.out.println("Invalid");
            // 세변의 길이기 모두 같은 경우
            } else if (b == c && c == a) {
                System.out.println("Equilateral");
            // 모두 다른 경우
            } else if (a != b && b != c && c != a) {
                System.out.println("Scalene");
            // 두변만 같은 경우
            } else {
                System.out.println("Isosceles");
            }
        }
    }
}
