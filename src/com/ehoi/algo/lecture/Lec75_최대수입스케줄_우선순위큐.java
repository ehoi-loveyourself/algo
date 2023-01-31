package com.ehoi.algo.lecture;

import java.util.*;

public class Lec75_최대수입스케줄_우선순위큐 {
    private static class Schedule implements Comparable<Schedule> {
        int cost;
        int day;

        public Schedule(int cost, int day) {
            this.cost = cost;
            this.day = day;
        }

        @Override
        public int compareTo(Schedule o) {
            // 기간이 긴게 우선이 되게 하려면
            if (this.day > o.day) {
                return -1;
            } else if (this.day == o.day){
                return 0;
            } else return 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 강의 개수
        int ans = 0;
        List<Schedule> list = new ArrayList<>();
        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            int cost = sc.nextInt();
            int day = sc.nextInt();
            maxDay = Math.max(maxDay, day);
            list.add(new Schedule(cost, day));
        }
        // 기간이 가장 넉넉한 순으로 정렬
        Collections.sort(list);

        // 강의료가 비싼 순으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = maxDay; i >= 1; i--) {
            // 기간이 넉넉한 순부터 볼 거야
            // i 날짜의 스케줄의 강의료만 pq에 넣을거야
            for (int j = 0; j < n; j++) {
                if (list.get(j).day == i)
                    pq.add(list.get(j).cost);
            }

            // 그럼 이제 고려대상으로 들어가있는 우선순위큐에서 가장 강의료가 높은 것을 i 날짜에 해야지!
            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }

        System.out.println(ans);

//        for (int i = 0; i < list.size(); i++) {
//            Schedule curr = list.get(i);
//            System.out.printf("%d원, %d일\n", curr.cost, curr.day);
//        }
        sc.close();
    }
}
