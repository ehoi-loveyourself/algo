package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DAY230218_BOJ14226_이모티콘_BFS_나중에다시도전 {
    private static int s;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = Integer.parseInt(br.readLine()); // 만들려는 이모티콘 개수

        arr = new int[1001];
        Arrays.fill(arr, -1);

        bfs();
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[s]);
        br.close();
    }

    private static void bfs() {
        Queue<Emoticon> q = new LinkedList<>();
        q.add(new Emoticon(1, 0, 0)); // 1개는 화면에 있으므로 0초에 완성된다.
        arr[1] = 0; // 1개는 0초에 완성된다. 방문처리

        while (!q.isEmpty()) {
            Emoticon now = q.poll();

            // 현재 이모티콘 개수가 s와 같다면
            if (s == now.cnt) {
                return;
            }

            // 복사하는 경우 : 1초 증가 + clip에 현 cnt 넣기
            q.add(new Emoticon(now.cnt, now.sec + 1, now.cnt));

            // 붙여넣기하는 경우
            if (now.clip != 0) { // 복사할 게 있어야 할 수 있다.
                addQueue( q, now, now.cnt + now.clip);
            }

            // 삭제하는 경우
            addQueue(q, now, now.cnt - 1);
        }
    }

    private static void addQueue(Queue<Emoticon> q, Emoticon e, int cnt) {
        if (check(cnt)) {
            int delSec = e.sec + 1;
            if (arr[cnt] == -1 || arr[cnt] > delSec) {
                arr[cnt] = delSec;
            }
            q.add(new Emoticon(cnt, delSec, e.clip));
        }
    }

    private static boolean check(int cnt) {
        return cnt >= 0 && cnt < arr.length;
    }

    private static class Emoticon {
        private int cnt;
        private int sec;
        private int clip;

        public Emoticon(int cnt, int sec, int clip) {
            this.cnt = cnt;
            this.sec = sec;
            this.clip = clip;
        }
    }
}
