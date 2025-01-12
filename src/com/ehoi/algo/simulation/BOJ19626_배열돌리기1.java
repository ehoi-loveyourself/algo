package com.ehoi.algo.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ19626_배열돌리기1 {
    static int N, M, R;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 회전해야하는 테두리를 계산
        int layersCnt = Math.min(N, M) / 2;
        for (int layer = 0; layer < layersCnt; layer++) {
            rotate(layer); // 2. R번 회전하러 가기
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 2. R번 회전하기
    private static void rotate(int layer) {
        // 범위 추출
        int startRow = layer;
        int startCol = layer;
        int endRow = N - 1 - layer;
        int endCol = M - 1 - layer;

        List<Integer> list = new ArrayList<>();
        // 반시계 방향이니까
        // 1. 위쪽 가로(왼 -> 오): 열만 움직임
        for (int col = startCol; col <= endCol; col++) list.add(arr[startRow][col]);
        // 2. 오른쪽 세로(위 -> 아래): 행만 움직임
        for (int row = startRow + 1; row <= endRow; row++) list.add(arr[row][endCol]);
        // 3. 아래쪽 가로(오 -> 왼): 열만 움직임
        for (int col = endCol - 1; col >= startCol; col--) list.add(arr[endRow][col]);
        // 4. 왼쪽 세로(아래 -> 위): 행만 움직임
        for (int row = endRow - 1; row > startRow; row--) list.add(arr[row][startCol]);

        // 리스트 회전
        // 회전 횟수 : R % 리스트 길이
        int rotateCnt = R % list.size();
        List<Integer> rotated = new ArrayList<>();
        // 지금 현재 list 0번째에 startRow, startCol에 들어가야 하는 것부터 들어가있으니까
        // rotateCnt만큼 회전하면 list.get(0 + rotateCnt)에 있는 애가 rotated 0번째에 들어가야 한다
        for (int i = rotateCnt; i < list.size(); i++) {
            rotated.add(list.get(i));
        }
        // 남은 거 채우기
        for (int i = 0; i < rotateCnt; i++) {
            rotated.add(list.get(i));
        }

        // 이제 rotated 리스트에 있는 값 순서대로 다시 arr에 채우기
        int idx = 0;
        // 1. 위쪽 가로(왼 -> 오): 열만 움직임
        for (int col = startCol; col <= endCol; col++) arr[startRow][col] = rotated.get(idx++);
        // 2. 오른쪽 세로(위 -> 아래): 행만 움직임
        for (int row = startRow + 1; row <= endRow; row++) arr[row][endCol] = rotated.get(idx++);
        // 3. 아래쪽 가로(오 -> 왼): 열만 움직임
        for (int col = endCol - 1; col >= startCol; col--) arr[endRow][col] = rotated.get(idx++);
        // 4. 왼쪽 세로(아래 -> 위): 행만 움직임
        for (int row = endRow - 1; row > startRow; row--) arr[row][startCol] = rotated.get(idx++);
    }
}