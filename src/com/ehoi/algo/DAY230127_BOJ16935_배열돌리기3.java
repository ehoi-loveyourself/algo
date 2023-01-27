package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY230127_BOJ16935_배열돌리기3 {
    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int comm = Integer.parseInt(st.nextToken());
            switch (comm) {
                case 1 :
                    upDown(); // 상하반전
                    break;
                case 2 :
                    leftRight(); // 좌우반전
                    break;
                case 3 :
                    rightRotate(); // 오른쪽으로 90도 회전
                    break;
                case 4 :
                    leftRotate(); // 왼쪽으로 90도 회전
                    break;
                case 5 :
                    fifthMove(); // 5번째 연산
                    break;
                case 6 :
                    sixthMove(); // 6번째 연산
                    break;
            }
        }

        // 결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%d ", map[i][j]);
            }
            System.out.println();
        }
        br.close();
    }

    private static void sixthMove() {
        int[][] newMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < n / 2) {
                    if (j < m / 2) {
                        // 1분면
                        newMap[i + n / 2][j] = map[i][j];
                    } else {
                        // 2분면
                        newMap[i][j - m / 2] = map[i][j];
                    }
                } else {
                    if (j < m / 2) {
                        // 4분면
                        newMap[i][j + m / 2] = map[i][j];
                    } else {
                        // 3분면
                        newMap[i - n / 2][j] = map[i][j];
                    }
                }
            }
        }
        map = newMap;
    }

    private static void fifthMove() {
        int[][] newMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < n / 2) {
                    if (j < m / 2) {
                        // 1분면
                        newMap[i][j + m / 2] = map[i][j];
                    } else {
                        // 2분면
                        newMap[i + n / 2][j] = map[i][j];
                    }
                } else {
                    if (j < m / 2) {
                        // 4분면
                        newMap[i - n / 2][j] = map[i][j];
                    } else {
                        // 3분면
                        newMap[i][j - m / 2] = map[i][j];
                    }
                }
            }
        }
        map = newMap;
    }

    private static void leftRotate() {
        int[][] newMap = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newMap[m - 1 - j][i] = map[i][j];
            }
        }
        // map 크기 변경
        int swap = n;
        n = m;
        m = swap;
        map = newMap;
    }

    private static void rightRotate() {
        int[][] newMap = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newMap[j][n - 1 - i] = map[i][j];
            }
        }
        // map 크기 변경
        int swap = n;
        n = m;
        m = swap;
        map = newMap;
    }

    private static void leftRight() {
        int[][] newMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newMap[i][m - 1 - j] = map[i][j];
            }
        }
        map = newMap;
    }

    private static void upDown() {
        int[][] newMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newMap[n - 1 - i][j] = map[i][j];
            }
        }
        map = newMap;
    }
}
