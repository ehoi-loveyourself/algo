package com.ehoi.algo;

public class DAY220917_PRO_구현_자물쇠와열쇠 {
    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;

        // 1. 자물쇠를 넉넉하게 처리
        int[][] map = new int[n * 3][n * 3];

        // 2. 자물쇠를 가운데에 집어넣기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i + n][j + n] = lock[i][j];
            }
        }

        // 3. 4번 회전을 해야하므로
        for (int r = 0; r < 4; r++) {
            // 열쇠를 회전시키자
            key = rotate(key);

            // map을 돌면서
            for (int i = 0; i < 2 * n; i++)
                for (int j = 0; j < 2 * n; j++) {
                    // map에 열쇠를 끼워보자
                    for (int x = 0; x < m; x++) {
                        for (int y = 0; y < m; y++) {
                            map[i + x][j + y] += key[x][y];
                        }
                    }
                    // 확인해보자
                    if (check(map)) return true;
                    // map에서 열쇠를 빼자
                    for (int x = 0; x < m; x++) {
                        for (int y = 0; y < m; y++) {
                            map[i + x][j + y] -= key[x][y];
                        }
                    }
                }
        }
        // 여기까지 나왔다면 실패인 것임
        return false;
    }

    private static int[][] rotate(int[][] k) {
        int len = k.length;
        int[][] res = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                res[j][len - i - 1] = k[i][j];
            }
        }
        return res;
    }

    private static boolean check(int[][] map) {
        int n = map.length / 3;
        for (int i = n; i < 2 * n; i++) {
            for (int j = n; j < 2 * n; j++) {
                if (map[i][j] != 1) return false;
            }
        }
        return true;
    }
}
