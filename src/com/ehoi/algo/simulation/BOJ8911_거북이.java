package com.ehoi.algo.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8911_거북이 {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int t = 0; t < tc; t++) {
            // 명령 입력받기
            char[] go = br.readLine().toCharArray();

            execute(go);
        }
    }

    static int direction;
    static int x;
    static int y;
    static int minx, maxx, miny, maxy;

    private static void execute(char[] go) {
        direction = 0;
        x = y = minx = maxx = maxy = miny = 0;
        for (char c : go) {
            switch (c) {
                case 'F':
                    forward();
                    break;
                case 'B':
                    back();
                    break;
                case 'L':
                    left();
                    break;
                case 'R':
                    right();
                    break;
            }

            // 최대 최소 거리 갱신
            renewMaxLength();
        }

        calculateArea();
    }

    private static void forward() {
        x += dx[direction];
        y += dy[direction];
    }

    private static void back() {
        x -= dx[direction];
        y -= dy[direction];
    }

    private static void left() {
        direction--;
        if (direction == -1) {
            direction = 3;
        }
    }

    private static void right() {
        direction++;
        if (direction == 4) {
            direction = 0;
        }
    }

    private static void renewMaxLength() {
        minx = Integer.min(minx, x);
        maxx = Integer.max(maxx, x);
        miny = Integer.min(miny, y);
        maxy = Integer.max(maxy, y);
    }

    private static void calculateArea() {
        int a = maxx - minx;
        int b = maxy - miny;
        System.out.println(a * b);
    }
}