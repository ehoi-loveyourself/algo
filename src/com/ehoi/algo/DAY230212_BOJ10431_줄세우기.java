package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DAY230212_BOJ10431_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken()); // 테스트 케이스
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // 테스트 번호 버리기

            List<Integer> list = new ArrayList<>();
            int ans = 0;
            for (int i = 0; i < 20; i++) {
                // 현재 학생보다 리스트에 더 큰 학생이 몇 명 있는지 확인
                int curr = Integer.parseInt(st.nextToken());

                int cnt = 0;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) > curr) cnt++;
                }
                ans += cnt;

                list.add(curr);
            }
            System.out.printf("%d %d\n", t, ans);
        }
    }
}
