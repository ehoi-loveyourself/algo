package com.ehoi.algo.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ13335_트럭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 트럭 개수
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int l = Integer.parseInt(st.nextToken()); // 다리 최대 하중

        st = new StringTokenizer(br.readLine()); // 트럭의 무게
        List<Truck> trucks = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 트럭의 무게와 현재 위치를 0으로 생성해서 리스트에 넣는다.
            int weight = Integer.parseInt(st.nextToken());
            trucks.add(new Truck(weight, 0));
        }

        int totalWeight = 0; // 총 탑승 중인 트럭 무게
        int totalCnt = 0; // 총 탑승 중인 트럭 대수
        int minute = 0;

        while (!trucks.isEmpty()) {
            minute++;

            // 트럭이 도착했는지 확인하고 도착했으면 꺼내준다.
            // 그리고 트럭의 무게도 현재 총 무게에서 빼준다.
            Truck truck = trucks.get(0);
            if (truck.position == w) {
                trucks.remove(0);
                totalWeight -= truck.weight;
                totalCnt--;
            }

            // 그 다음이 트럭을 이동시킨다.
            // 이동 중인 트럭이라면 현재 위치가 0이 아니다. 도착한 트럭은 이미 리스트에서 빠지고 없다.
            // 아 이동시킬 트럭이 하나일리가 없구나. // 여기서 위치가 0이 나오면 바로 break 시키고 나가자 다 보지 말고
            for (Truck t : trucks) {
                if (t.position == 0) break;
                if (t.position > 0) {
                    t.position++;
                }
            }

            // 트럭을 탑승시킨다.
            // 위치가 0인 가장 앞에 있는 트럭을 찾는다.
            // 탑승이 가능한지 w와 l을 체크한다.
            // 탑승이 가능하다면 현재 무게에 더해주고
            // 본인의 위치를 +1 한다.
            if (w == totalCnt) continue;

            int waiting = -1;
            for (int i = 0; i < trucks.size(); i++) {
                if (trucks.get(i).position == 0) {
                    waiting = i;
                    break; // 첫번째 트럭만 찾고 바로 나온다.
                }
            }
            if (waiting == -1) continue; // 탑승시킬 트럭이 없다는 뜻이므로
            Truck truck1 = trucks.get(waiting);
            if (l < totalWeight + truck1.weight) continue;

            totalWeight += truck1.weight;
            totalCnt++;
            truck1.position++;
        }

        System.out.println(minute);
    }

    static class Truck {
        int weight;
        int position;

        Truck(int weight, int position) {
            this.weight = weight;
            this.position = position;
        }
    }
}