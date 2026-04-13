import java.util.*;

public class BinarySearch {

    // 기본 이분탐색 - 값 존재 여부
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // 오버플로우 방지

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // 없으면 -1
    }

    // lower_bound - target 이상인 첫 번째 인덱스
    static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) left = mid + 1;
            else right = mid; // 같아도 right 줄임 (첫 번째 위치 찾기)
        }
        return left;
    }

    // upper_bound - target 초과인 첫 번째 인덱스
    static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) left = mid + 1; // 같아도 left 올림
            else right = mid;
        }
        return left;
    }

    // 파라메트릭 서치 - "mid값이 조건을 만족하는가?" 로 이분탐색
    // ex. 최소 몇 개로 나눠야 하는가, 최대 길이는 얼마인가
    static int parametricSearch(int[] arr, int condition) {
        int left = 1, right = 1_000_000_000; // 범위는 문제에 맞게 조정
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(arr, mid, condition)) {
                result = mid;       // 조건 만족 → 정답 후보 저장
                left = mid + 1;     // 더 큰 값도 가능한지 탐색 (최댓값 구할 때)
                // right = mid - 1; // 최솟값 구할 때는 이쪽
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // 조건 함수 - 문제에 맞게 구현
    static boolean isPossible(int[] arr, int mid, int condition) {
        // ex. mid 길이로 자를 때 condition개 이상 나오는가?
        int count = 0;
        for (int val : arr) count += val / mid;
        return count >= condition;
    }
}
