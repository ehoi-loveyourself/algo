package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class DAY230223_BOJ22233_가희와키워드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 메모장에 있는 키워드 수
        int m = Integer.parseInt(st.nextToken()); // 블로그에 쓴 글 수

        Set<String> keywords = new HashSet<>();
        for (int i = 0; i < n; i++) {
            keywords.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String[] written = br.readLine().split(",");
            for (String word : written) {
                keywords.remove(word);
            }
            System.out.println(keywords.size());
        }
    }
}
