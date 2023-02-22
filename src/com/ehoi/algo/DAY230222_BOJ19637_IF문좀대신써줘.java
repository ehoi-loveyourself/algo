package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY230222_BOJ19637_IF문좀대신써줘 {
    public static void main(String[] args) throws IOException {
        // 이분탐색문제
        // 점수를 기준으로 탐색을 해야하는지 뭐 어떻게 해야하는지 잘 몰랐는데
        // 결국엔 레벨을 기준으로 나누는 것이니까 배열의 idx를 가지고 이분탐색을 했다
        // 그리고 주어지는 범위와 제한 시간을 봤을 때 빡빡한걸 봐서
        // 입출력에도 신경써야겠다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 칭호 개수
        int m = Integer.parseInt(st.nextToken()); // 판단할 캐릭터 개수

        String[][] level = new String[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                level[i][j] = st.nextToken();
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());

            // 이분 탐색 시작
            int left = 0;
            int right = n - 1;
            int mid = (left + right) / 2;

            while (left <= right) {
                mid = (left + right) / 2; // 1

                // mid 레벨 기준의 파워보다 내 파워가 더 크면 난 mid 아래에 있는 레벨은 아니야!
                if (Integer.parseInt(level[mid][1]) < power) { // 100000 vs 50000
                    left = mid + 1;
                } else {
                    // 이 레벨의 파워보다 같거나 작으면 나는 mid 이하에 있는 레벨이야
                    right = mid - 1;
                }
            }

            // 이렇게 다 돌고 나오면 mid에 있는 값이 내 레벨이야
            ans.append(level[right + 1][0]).append("\n");
        }
        System.out.println(ans);
    }
}
