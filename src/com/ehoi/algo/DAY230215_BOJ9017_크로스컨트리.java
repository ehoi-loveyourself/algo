package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DAY230215_BOJ9017_크로스컨트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken()); // 테케 수
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            String tmp = br.readLine();

            st = new StringTokenizer(tmp);
            // 6명 이상 들어온 팀을 알아보자
            int[] teams = new int[201];
            int max = 0; // 가장 큰 팀 번호
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                max = Math.max(max, num);
                teams[num]++;
            }
            // 가장 큰 팀 번호까지만 돌면서 6명 이상인 팀 번호를 추려내자
            List<Integer> possibleTeam = new ArrayList<>();
            for (int i = 1; i <= max; i++) {
                if (teams[i] >= 6) {
                    possibleTeam.add(i);
                }
            }
            // 이제 그 팀으로만 이루어진 새로운 순서를 걸러야 한다
            List<Integer> newScore = new ArrayList<>();
            st = new StringTokenizer(tmp);
            for (int i = 0; i < n; i++) {
                int team = Integer.parseInt(st.nextToken());
                // 이 팀이 possibleTeam에 있어야 한다
                if (possibleTeam.contains(team)) {
                    newScore.add(team);
                }
            }

            List<Integer>[] successTeams = new ArrayList[max];
            for (int i = 1; i < successTeams.length; i++) {
                successTeams[i] = new ArrayList<>();
            }
            for (int i = 0; i < newScore.size(); i++) {
                int team = newScore.get(i);
                successTeams[team].add(i); // 등수 다 등록
            }

            int min = 987654321;
            int bonus = 0;
            int ans = 0;
            for (int i = 1; i < successTeams.length; i++) {
                List<Integer> team = successTeams[i];
                if (team.size() < 6) continue;
                int sum = 0;
                for (int j = 0; j < 4; j++) {
                    sum += team.get(j); // 4등까지 점수를 구함
                }
                if (min > sum) {
                    min = sum;
                    ans = i; // 등수 합이 가장 적으면 너가 우승이지
                    bonus = team.get(4); // 너네 5등 점수 기록해두고
                } else if (min == sum) { // 근데 만약 같으면
                    // 1등팀네 5등 점수보다 우리팀 5등 점수가 더 적으면
                    if (bonus > team.get(4)) {
                        ans = i;
                        bonus = team.get(4);
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
// 자격 : 팀의 참가한 인원이 6명이 안되면 점수를 받을 수 없다.
// 상위 네명의 점수가 동일하면 5번째 주자의 등수를 비교하여 더 적은 팀이 우승한다.