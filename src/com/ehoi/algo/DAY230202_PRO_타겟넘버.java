package com.ehoi.algo;

public class DAY230202_PRO_타겟넘버 {
    static int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    private static void dfs(int[] numbers, int target, int sum, int start) {
        if (start == numbers.length) {
            if (sum == target) answer++;
            return;
        }

        dfs(numbers, target, sum + numbers[start], start + 1);
        dfs(numbers, target, sum - numbers[start], start + 1);
    }
}
