package com.ehoi.algo;

import java.util.*;

public class DAY230202_PRO_단어변환 {
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        // 1단계 검증
        boolean flag = false;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) flag = true;
        }
        if (!flag) return 0;

        // 2단계 검증
        visited = new boolean[words.length];
        answer = bfs(begin, target, words);

        return answer;
    }

    private static int bfs(String begin, String target, String[] words) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(begin, 0));

        while (!q.isEmpty()) {
            Point curr = q.poll();

            if (curr.str.equals(target)) {
                return curr.move;
            }

            // 그게 아니라면 단어들을 하나씩 탐색하면서
            // 이미 방문한 단어는 제외
            // 단어 변환이 가능한지 체크
            // 가능하면 큐에 담고
            // 방문처리도 하고
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;
//                if (check(words[i], target)) { // 내가 무심결에 비교해야 할 단어를 target을 대상으로 삼았다! 의식하면서 코딩하자
                if (check(words[i], curr.str)) {
                    visited[i] = true;
                    q.add(new Point(words[i], curr.move + 1));
                }
            }
        }
        // 아무것도 없으면 결국엔 0
        return 0;
    }

    // 알파벳이 하나만 달라야해
    private static boolean check(String word, String target) {
        int diff = 0;

        for (int i = 0; i < target.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) diff++;
        }

        if (diff == 1) return true;
        else return false;
    }

     // Map으로 구현해야하나.. 생각했는데 class 로 구현하면 이렇게 쉽군! 알면서도 구현을 못하는 것은 내 실력이 아니다 제대로 하자!
    private static class Point {
        String str;
        int move;

        public Point(String str, int move) {
            this.str = str;
            this.move = move;
        }
    }
}

/*
가장 짧은 과정 이므로 bfs로 풀자
한 번에 한 개의 알파벳만 변경 가능
words에 있는 단어로만 변환 가능
변환이 불가능하다면 0을 리턴
예제 2번처럼 target 단어가 words 안에 없어도 바로 0 리턴가능 : 이건 제일 먼저 검증해보기
*/