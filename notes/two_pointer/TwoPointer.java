import java.util.*;

public class TwoPointer {

    // 패턴 1 - 양끝에서 좁히기
    // 정렬된 배열에서 두 수의 합이 target인 쌍 찾기
    static void twoSum(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                System.out.println(arr[left] + " " + arr[right]);
                left++; right--;
            } else if (sum < target) {
                left++;  // 합이 작으면 left 올림
            } else {
                right--; // 합이 크면 right 내림
            }
        }
    }

    // 패턴 2 - 같은 방향 슬라이딩
    // 연속 부분합이 target 이상인 최소 길이
    static int minSubarray(int[] arr, int target) {
        int left = 0, sum = 0;
        int result = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right]; // right 확장

            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= arr[left++]; // 조건 만족하면 left 당김
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    // 패턴 3 - 슬라이딩 윈도우
    // 중복 없는 최장 부분 문자열 길이
    static int longestUniqueSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, result = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // 중복 문자 나오면 left를 중복 위치 다음으로 이동
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    // 패턴 4 - 정렬된 두 배열 병합
    // 두 배열의 공통 원소 찾기
    static List<Integer> commonElements(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                result.add(a[i]);
                i++; j++;
            } else if (a[i] < b[j]) {
                i++; // a 포인터 전진
            } else {
                j++; // b 포인터 전진
            }
        }
        return result;
    }
}
