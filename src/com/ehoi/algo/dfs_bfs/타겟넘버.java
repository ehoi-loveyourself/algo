package com.ehoi.algo.dfs_bfs;

public class 타겟넘버 {
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }

    static int answer = 0;
    private void dfs(int sum, int start, int[] numbers, int target) {
        if (start == numbers.length) {
            if (target == sum) {
                answer++;
            }
            return;
        }

        dfs(sum - numbers[start], start + 1, numbers, target);
        dfs(sum + numbers[start], start + 1, numbers, target);
    }
}