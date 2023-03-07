package com.ehoi.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lec86_피자배달거리 {
    static List<Pair> home;
    static List<Pair> pizzas;
    static int ans = Integer.MAX_VALUE; // 도시의 최소피자배달거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 도시 지도 크기
        int m = Integer.parseInt(st.nextToken()); // 살릴 피자집 개수

        // 입력 받으면서 집과 피자의 좌표 저장할 list 선언
//        int[][] map = new int[n][n]; // 굳이 필요없네
        home = new ArrayList<>();
        pizzas = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) home.add(new Pair(i, j));
                if (num == 2) pizzas.add(new Pair(i, j));
            }
        }

        // m개 만큼 피자 집 조합을 선택하는 dfs를 돌리고
        int[] selected = new int[m];
        dfs(0, 0, m, selected, pizzas.size());

        // 그걸 출력하면 됨
        System.out.println(ans);
    }

    private static void dfs(int start, int cnt, int m, int[] selected, int pizzaSize) {
        if (cnt == m) {
            // m개를 선택했다면, 선택한 피자가게와 집간의 최소 배달거리를 구하고 그것을 모두 더해서
            int sum = 0;
            //  -----------------실수 : 여기서 기준이 Pizza 가게가 아니고 집이 되어야 함------------------
            // 집에서 피자가게까지의 배달거리를 통해서 집 개수만큼 더해져야함
            for (int i = 0; i < home.size(); i++) {
                sum += calMinimum(home.get(i), selected);
            }
            ans = Math.min(ans, sum);
            // 그 거리가 도시의 최소 피자배달거리인지를 비교한다
            return;
        }

        for (int i = start; i < pizzaSize; i++) {
            selected[cnt] = i;
            dfs(i + 1, cnt + 1, m, selected, pizzaSize);
        }
    }

    private static int calMinimum(Pair home, int[] selected) {
        // 하나의 집 위치
        // 여러 피자가게들의 위치
        // 최소피자배달거리를 구하라
        int min = Integer.MAX_VALUE;
        for (int i : selected) {
            Pair pizza = pizzas.get(i);

            min = Math.min(min, Math.abs(home.x - pizza.x) + Math.abs(home.y - pizza.y));
        }
        return min;
    }

    private static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
