package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DAY230214_BOJ1205_등수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 랭킹 n개
        int myScore = Integer.parseInt(st.nextToken()); // 내 점수
        int total = Integer.parseInt(st.nextToken()); // 랭킹 최대 몇개

        if (n == 0) { // 랭킹에 아무도 없으면 니가 1등이야
            System.out.println(1);
            System.exit(0);
        }

        List<Integer> scores = new ArrayList<>();
        st = new StringTokenizer(br.readLine()); // 읽을 게 없을 수도 있어
        while (st.hasMoreTokens()) {
            scores.add(Integer.parseInt(st.nextToken()));
        }

        // 랭킹이 꽉 차 있고, 내 노래가 꼴찌노래 점수와 같거나 작으면
        if (n == total && myScore <= scores.get(n - 1)) {
            System.out.println(-1);
        } else {
            // 비어있다면 랭킹에 등록될 수 있다! 등수를 구해오자
            System.out.println(getMyRank(myScore, scores));
        }
    }

    private static int getMyRank(int myScore, List<Integer> scores) {
        int rank = 1;
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) > myScore) {
                rank++;
            } else {
                break;
            }
        }
        return rank;
    }
}
