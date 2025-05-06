package com.ehoi.algo.dfs_bfs;

public class 단어변환 {
    private int answer = Integer.MAX_VALUE;
    private boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        // 일단 words에 target이 없으면 0을 리턴
        boolean flag = false;
        for (String word : words) {
            if (word.equals(target)) {
                flag = true;
                break;
            }
        }
        if (!flag) return 0;

        // 계속 탐색해서 들어가면서 단어를 바꿔보면서 target 단어로 변환할 수 있는지 확인해보기
        visited = new boolean[words.length];
        dfs(0, begin, target, words);
        return answer;
    }

    // static boolean[] visited;
    private void dfs(int depth, String begin, String target, String[] words) {
        // begin과 target이 같다면 depth를 리턴
        if (begin.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }

        // words 배열을 돌면서 begin과 글자가 하나만 다른 게 있다면 그걸 begin으로 해서 더 들어가보기, depth + 1
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && check(words[i], begin)) {
                visited[i] = true;
                dfs(depth + 1, words[i], target, words);
                visited[i] = false;
            }
        }
    }

    private boolean check(String begin, String word) {
        int diff = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) {
                diff++;
            }
        }

        // 하나만 달라야 true 리턴
        return diff == 1;
    }
}