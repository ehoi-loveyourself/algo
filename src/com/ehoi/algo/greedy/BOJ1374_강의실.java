package com.ehoi.algo.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 풀이 포인트
강의 시작시간을 기준으로 정렬하자
*/
public class BOJ1374_강의실 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 강의실 개수
        int n = Integer.parseInt(st.nextToken());

        // 강의실 정보를 받자
        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int no = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Lecture lec = new Lecture(no, start, end);
            lectures.add(lec);
        }

        // 강의실 정보를 정렬하자
        Collections.sort(lectures);

        // 우선순위 큐를 구현하여 강의 끝시간이 빠른 강의실 순으로 관리하도록 하자
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Lecture lecture : lectures) {
            // 처음에는 제일 일찍 시작하는 강의를 넣어준다
            if (pq.isEmpty()) {
                pq.add(lecture.end);
            } else {
                // 가장 빨리 끝나는 강의를 가져온다.
                int end = pq.peek();
                // 그 강의 종료 시간보다 현재 강의 시작 시간이 뒤라면 이 강의실을 재사용한다.
                if (lecture.start >= end) {
                    pq.poll();
                    pq.add(lecture.end);
                } else { // 더 빨리 시작한다면 다음 강의실을 이용한다.
                    pq.add(lecture.end);
                }
            }
        }

        System.out.println(pq.size());
    }

    static class Lecture implements Comparable<Lecture> {
        int no;
        int start;
        int end;

        Lecture(int no, int start, int end) {
            this.no = no;
            this.start = start;
            this.end = end;
        }

        public int compareTo(Lecture o) {
            // 강의 시간이 짧은 것부터 정렬
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}