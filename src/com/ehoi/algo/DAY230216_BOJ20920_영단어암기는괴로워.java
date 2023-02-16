package com.ehoi.algo;

import java.io.*;
import java.util.*;

public class DAY230216_BOJ20920_영단어암기는괴로워 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 단어의 개수
        int m = Integer.parseInt(st.nextToken()); // 얘 이상인 거만 외움

        Map<String, Integer> words = new HashMap<>();
        while (n-- > 0) {
            String word = br.readLine();
            if (word.length() < m) continue;
            words.put(word, words.getOrDefault(word, 0) + 1);
        }
        List<String> keySet = new ArrayList<>(words.keySet());

        // 이제 정렬을 하자
        // 1. 자주 나오는 단어 먼저
        // 2. 단어의 길이가 길수록 먼저
        // 3. 사전 오름차순
        keySet.sort((k1, k2) -> {
           int v1 = words.get(k1);
           int v2 = words.get(k2);

           if (v1 == v2) {
               if (k1.length() == k2.length()) {
                   return k1.compareTo(k2);
               }
               return k2.length() - k1.length();
           }
           return v2 - v1;
        });

        StringBuilder sb = new StringBuilder();

        for (String key : keySet) {
            sb.append(key).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
