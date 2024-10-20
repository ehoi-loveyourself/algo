package com.ehoi.algo.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ12015_가장긴증가하는부분수열2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다.
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        // 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000,000)
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 가장 긴 부분수열을 만들기
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (list.isEmpty()) {
                list.add(arr[i]);
            } else {
                // 리스트에 있는 가장 마지막 애가 arr[i] 보다 작으면 arr[i] 추가
                if (list.get(list.size() - 1) < arr[i]) {
                    list.add(arr[i]);
                } else {
                    // 이분탐색 시작
                    int left = 0;
                    int right = list.size() - 1;

                    while (left < right) {
                        int mid = (left + right) / 2;
                        if (list.get(mid) >= arr[i]) {
                            // 부분 수열에 있는 이 값은 arr[i]로 대체 가능하다는 뜻 임
                            right = mid;
                        } else {
                            // 부분 수열에 있는 이 값이 arr[i] 보다 작으므로 굳이 대체할 필요 없음
                            left = mid + 1;
                        }
                    }
                    list.set(right, arr[i]); // 대체
                }
            }
        }

        System.out.println(list.size());
    }
}