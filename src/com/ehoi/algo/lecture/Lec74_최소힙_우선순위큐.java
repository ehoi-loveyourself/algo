package com.ehoi.algo.lecture;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Lec74_최소힙_우선순위큐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (true) {
            int num = sc.nextInt();
            // -1이 입력되면 프로그램을 종료한다.
            if (num == -1) break;
            // 0이 입력되면 최댓값을 꺼내어 출력한다.
            // 출력할 자료가 없다면 -1을 출력한다.
            else if (num == 0) {
                if (pq.isEmpty()) System.out.println(-1);
                else System.out.println(pq.poll());
            }
            // 자연수라면 최대힙에 입력
            else pq.add(num);
        }

        sc.close();
    }
}
