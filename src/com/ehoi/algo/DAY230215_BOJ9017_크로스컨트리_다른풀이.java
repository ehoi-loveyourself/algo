package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DAY230215_BOJ9017_크로스컨트리_다른풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken()); // 테케 수
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            boolean[] accepted = new boolean[201]; // 6명 들어온 팀
            int[] score = new int[201]; // 각 팀의 점수 합?
            int[] info = new int[n + 1]; // 각 선수의 팀 정보
            int[] cnt = new int[201];
            int[] five = new int[201]; // 5등 점수

            int rank = 1;
            int minSum = Integer.MAX_VALUE;
            int ans = 1;
            Arrays.fill(accepted, true);

            int max = 0;
            for (int i = 1; i <= n; i++) {
                int team = Integer.parseInt(st.nextToken()); // 팀 정보
                info[i] = team;
                cnt[team]++;
                max = Math.max(max, team); // 참가한 팀의 max 번호
            }

            for (int i = 1; i <= max; i++) {
                if (cnt[i] < 6) {
                    accepted[i] = false; // 6명이 못들어왔다면 자격 없음
                }
            }

            Arrays.fill(cnt, 0); // cnt 배열을 다시 0으로 초기화
            for (int i = 1; i <= n; i++) {
                // i번째로 들어온 팀이 자격이 없다면 그냥 넘기자
                if (!accepted[info[i]]) continue;

                if (cnt[info[i]] < 4) { // 4등까지는 계속 점수 합에 더해주자
                    score[info[i]] += rank;
                } else if(cnt[info[i]] == 4) { // 4등까지 다 들어왔으니까
                    // 5등을 저장해주자
                    five[info[i]] = rank;
                }
                cnt[info[i]]++;
                rank++;
            }

            for (int i = 1; i <= max; i++) {
                if (!accepted[i]) continue;
                if (score[i] < minSum) {
                    minSum = score[i];
                    ans = 1;
                } else if (score[i] == minSum) {
                    if (five[i] < five[ans]) {
                        ans = i;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
