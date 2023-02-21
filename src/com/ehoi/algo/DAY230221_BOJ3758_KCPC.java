package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DAY230221_BOJ3758_KCPC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());
        for (int a = 0; a < tc; a++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀의 개수
            int k = Integer.parseInt(st.nextToken()); // 문제 개수
            int t = Integer.parseInt(st.nextToken()); // 본인 팀 아이디
            int m = Integer.parseInt(st.nextToken()); // 로그 개수

            int[][] score = new int[n + 1][k + 1];
            int[] submitCnt = new int[n + 1];
            int[] lastSubmitTime = new int[n + 1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int testNo = Integer.parseInt(st.nextToken());
                int scoreByTestNo = Integer.parseInt(st.nextToken());

                submitCnt[teamId]++;
                lastSubmitTime[teamId] = i;
                score[teamId][testNo] = Math.max(score[teamId][testNo], scoreByTestNo);
            }

            Team[] teams = new Team[n];
            for (int i = 1; i <= n; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    sum += score[i][j];
                }
                teams[i - 1] = new Team(i, sum, submitCnt[i], lastSubmitTime[i]);
            }
            Arrays.sort(teams);

            for (int i = 0; i < teams.length; i++) {
                if (teams[i].teamId == t) {
                    // 실수 2번
//                    System.out.println(t + 1);
                    System.out.println(i + 1);
                    break;
                }
            }
//             디버깅
//            for (int i = 1; i <= n; i++) {
//                System.out.println(i + "팀의 정보");
//                System.out.println("총점 : " + teams[i].totalScore);
//                System.out.println("제출횟수 : " + teams[i].submitCnt);
//                System.out.println("마지막 제출시간 : " + teams[i].lastSubmitTime);
//            }
//
//            System.out.println(Arrays.deepToString(res));
        }
    }

    static class Team implements Comparable<Team> {
        int teamId;
        int totalScore;
        int submitCnt;
        int lastSubmitTime;

        public Team(int teamId, int totalScore, int submitCnt, int lastSubmitTime) {
            this.teamId = teamId;
            this.totalScore = totalScore;
            this.submitCnt = submitCnt;
            this.lastSubmitTime = lastSubmitTime;
        }

        @Override
        public int compareTo(Team o) {
            if (this.totalScore == o.totalScore) {
                // 풀이 제출 횟수가 적은 팀
                if (this.submitCnt == o.submitCnt) {
                    // 제출 시간이 빠른 팀
                    // 실수 1번
//                    return this.lastSubmitTime = o.lastSubmitTime;
                    return this.lastSubmitTime - o.lastSubmitTime;
                }
                return this.submitCnt - o.submitCnt;
            }
            return o.totalScore - this.totalScore;
        }
    }
}