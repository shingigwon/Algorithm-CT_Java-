import java.util.*;

public class Greedy {

    // 회의실 배정 - 종료 시간 기준 정렬 후 탐욕 선택
    static int meetingRoom(int[][] meetings) {
        // 종료 시간 오름차순, 같으면 시작 시간 오름차순
        Arrays.sort(meetings, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);

        int count = 0;
        int lastEnd = 0; // 마지막으로 선택한 회의 종료 시간

        for (int[] meeting : meetings) {
            if (meeting[0] >= lastEnd) { // 시작 시간이 이전 종료 이후면 선택
                count++;
                lastEnd = meeting[1];
            }
        }
        return count;
    }

    // 최소 동전 개수 - 큰 단위부터 greedy (단, 배수 관계일 때만 보장)
    static int minCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int count = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            count += target / coins[i]; // 해당 동전으로 최대한 사용
            target %= coins[i];         // 나머지
        }
        return count;
    }

    // 구간 합치기 - 겹치는 구간 최소 개수로 커버
    static int minIntervals(int[][] intervals) {
        // 시작 시간 오름차순 정렬
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int count = 1;
        int[] cur = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= cur[1]) {
                // 겹치면 합침 (더 늦은 종료 시간으로 갱신)
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                // 안 겹치면 새 구간 시작
                count++;
                cur = intervals[i];
            }
        }
        return count;
    }

    // 가장 큰 수 만들기 - 문자열 정렬 기준 커스텀
    static String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) strs[i] = String.valueOf(nums[i]);

        // "34" + "3" vs "3" + "34" 비교해서 더 큰 쪽 앞으로
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        if (strs[0].equals("0")) return "0";
        return String.join("", strs);
    }
}
