package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class DAY230210_BOJ1713_후보추천하기 {
    static class Student implements Comparable<Student> {
        // 순서
        // 후보 번호
        // 추천수
        private int seq;
        private int no;
        private int cnt;

        public Student(int seq, int no, int cnt) {
            this.seq = seq;
            this.no = no;
            this.cnt = cnt;
        }

        @Override
        // 밖에서도 이용가능 해야하니까 public
        // 리턴되는 숫자를 바탕으로 정렬을 하니까 int
        // 메서드 이름은 compareTo
        // 인자는 같은 Student 객체를 비교하니까 Student
        public int compareTo(Student o) {
            // 추천 받은 횟수가 같다면 가장 오래된 사진
            if (this.cnt == o.cnt) {
                return this.seq - o.seq;
            }
            // 추천 받은 횟수가 적은 학생
            return this.cnt - o.cnt;
        }
    }

    static List<Student> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 추천 받은 학생들을 담을 list 생성
        list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine()); // 사진틀 개수
        int total = Integer.parseInt(br.readLine()); // 총 추천 횟수
        st = new StringTokenizer(br.readLine()); // 추천 순서

        for (int j = 0; j < total; j++) {
            int who = Integer.parseInt(st.nextToken());
            // 리스트에 그냥 들어가도 되더라도
            if (list.size() < n) {
                // 친구가 리스트안에 있는지 검사해봐야지
                if (!check(who)) {
                    list.add(new Student(j, who, 1));
                }
            } else { // 안되면
                // 리스트에 who 있는지 확인
                if (!check(who)) { // 없었으니까
                    Collections.sort(list);
                    // 기준에 맞게 제외하고
                    list.remove(0);
                    // 그리고 새로운 친구 추가하자
                    list.add(new Student(j, who, 1));
                }
            }
        }
        // 여기까지 온 list에는 최종후보가 있다
        List<Integer> answer = new ArrayList<>();
        for (Student stu : list) {
            answer.add(stu.no);
        }
        Collections.sort(answer);
        for (int num : answer) {
            System.out.printf("%d ", num);
        }
    }

    private static boolean check(int who) {
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            Student curr = list.get(i); // 학생
            // 있다면
            if (curr.no == who) {
                curr.cnt++; // 추천횟수 올려주고
                flag = true; // 그런 애 있었어
                break; // 처리 했으니까 다음 학생 보러 가자
            }
        }
        return flag;
    }
}



/*
- 추천받은 학생이 사진틀에 있다면
    - 그 친구 ++
- 없다면
    - 사진틀이 꽉 찼다면
        - list에서 추천수가 가장 낮은 아이 제거하고
        - 그 친구 추가하고 추천수는 1
    - 사진틀이 비었다면
        - 그 친구 추가하고 추천수는 1 (중복이니까 한꺼번에 밑에서 처리)

그러면 Comparable을 구현한 클래스를 만들어야 겠다.
 */
