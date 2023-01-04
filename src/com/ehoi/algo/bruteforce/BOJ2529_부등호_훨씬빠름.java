package com.ehoi.algo.bruteforce;

import java.io.*;
import java.util.*;

public class BOJ2529_부등호_훨씬빠름 {
    static int k;
    static char[] arr;
    static boolean[] visited = new boolean[10];
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 다 받고 배열들 초기화 하기
        k = Integer.parseInt(br.readLine().trim());
        arr = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        // 재귀 던지기
        recur(0, "");
        // 리스트 정렬하기
        Collections.sort(list);

        // 최댓값과 최솟값 출력하기
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));

        br.close();
    }

    // 메서드
    // base : 조건에 만족하는 거는 전부 리스트에 담는다.
    // recur : 숫자를 하나씩 넣을 때마다 조건을 검색해서 부합하는 것만 넣는다.
    private static void recur(int cnt, String nums) {
        if (cnt == k + 1) {
            list.add(nums);
            return;
        }

        /*
         * 내가 작성한 메서드는, 숫자 조합을 모두 찾은 후에 베이스 문에서 조건을 검사했다면,
         * 이 풀이는 숫자를 조합할때부터 조건에 맞는지를 미리 검사하기 때문에
         * 조건에 부합하지 않는 많은 후보를 미리 백트래킹할 수 있다. 그렇기 때문에 속도가 많이 차이가 남.
         * 내가 푼 것은 416ms, 참고하고 푼 것은 188ms
         */
        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            if (cnt == 0 || check(nums.charAt(nums.length() - 1) - '0', i, arr[cnt - 1])) {
                visited[i] = true;
                recur(cnt + 1, nums + i);
                visited[i] = false;
            }
        }
    }

    private static boolean check(int a, int b, char sign) {
        if (sign == '<') return a < b;
        else return a > b;
    }
}
