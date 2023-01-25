package com.ehoi.algo.lecture;

import java.util.Scanner;

// 분할정복의 시간복잡도는 n log n
public class Lec62_병합정렬 {
    static int n;
    static int[] arr, tmp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n + 1];
        tmp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        divide(1, n);
        for (int i = 1; i <= n; i++) {
            System.out.printf("%d ", arr[i]);
        }
        sc.close();
    }

    private static void divide(int start, int end) { // 1, 8
        int mid;
        int left, right, pos;
        // start가 end보다 작을 때만 분할을 할 수가 있쥬? 같으면 분할이 안돼요!
        if (start < end) {
            // 분할이 되니까 분할을 해야죠!
            mid = (start + end) / 2; // 4
            divide(start, mid); // (1, 4)
            divide(mid + 1, end); // (5, 8)
            // 분할을 했으니 이제 정복을 합시다
            // 해야할 정복 : 차례대로 수 정렬하는 것
            left = start; // 1
            right = mid + 1; // 5
            pos = start; // 1

            // 이 범위까지안에서만 Left뢍 right가 활동할 수 있어
            while (left <= mid && right <= end) {
                // left와 right 대소비교
                if (arr[left] < arr[right]) {
                    tmp[pos++] = arr[left++];
                } else {
                    tmp[pos++] = arr[right++];
                }
            }
            // 남은 것들 처리
            while (left <= mid) {
                tmp[pos++] = arr[left++];
            }
            while (right <= end) {
                tmp[pos++] = arr[right++];
            }
            // tmp에서 arr로 옮겨담기
            // 범위는 지금 정복하고 있는 start ~ end
            for (int i = start; i <= end; i++) {
                arr[i] = tmp[i];
            }
        }
    }
}
