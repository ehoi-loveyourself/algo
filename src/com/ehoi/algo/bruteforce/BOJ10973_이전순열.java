package com.ehoi.algo.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10973_이전순열 {
    static int n;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if (hasPrePerm()) {
            StringBuilder sb = new StringBuilder();
            for (int i : nums) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }

        br.close();
    }

    /**
     * 이전 순열을 찾으려면 나보다 하나 작은 수를 찾아야 한다.
     * 가장 작은 수 = 모든 수가 오름차순인 수
     * 오름차순이다가 내림차순인 지점을 만나면 더 작은 수로 바꿔줘야 할 때
     */
    private static boolean hasPrePerm() {
        // 오름차순이다가 내림차순인 지점을 찾자
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] < nums[i]) i--;
        if (i == 0) return false;

        // i - 1과 바꿀 j를 찾아야 한다.
        // j는 뒤에서부터 찾으면서 nums[i - 1]보다 작은 nums[j]를 찾아야 한다.
        int j = nums.length - 1;
        while (nums[i - 1] < nums[j]) j--; // 그러므로 nums[j]가 클 동안에는 pass 한다.

        // while 반복문이 멈췄다면 그 j 지점이 nums[i - 1]보다 작은 지점임!
        // 교환해준다
        swap(i - 1, j);

        // i부터 그 뒤의 숫자들이 오름차순으로 정렬되어 있을 것이다.
        // i - 1을 이전 i - 1보다 작은 수로 바꾸었으니
        // i부터는 가장 큰 수로 정렬이 되어야 이전 순열이 될 수 있다!
        // 그러므로 swap을 해주겠다! 중간 지점까지면 해주면 되니까 i와 j가 교차하기 전까지만 해준다.
        // i == j 지점은 어차피 같은 애를 swap해주는 개념이므로 굳이 해줄 필요 없다.
        j = nums.length - 1; // 다시 세팅
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }

    private static void swap(int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
