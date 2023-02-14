package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class DAY230214_BOJ25757_임스와함께하는미니게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 같이 플레이하는 사람 수
        String game = st.nextToken(); // 게임 종류

        Set<String> name = new HashSet<>();
        for (int i = 0; i < n; i++) {
            name.add(br.readLine()); // 중복 제거
        }

        // 필터링된 사람 수
        int possibleN = name.size();

        if (game.equals("Y")) {
            System.out.println(possibleN);
        } else if (game.equals("F")) {
            System.out.println(possibleN / 2);
        } else {
            System.out.println(possibleN / 3);
        }

    }
}
