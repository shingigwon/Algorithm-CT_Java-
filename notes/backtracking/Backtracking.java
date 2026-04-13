import java.util.*;

public class Backtracking {

    static int N, R;
    static int[] arr;
    static boolean[] used;
    static List<Integer> cur = new ArrayList<>();

    // 순열 - 순서 있음, 중복 없음 (ex. N과 M (1))
    static void permutation(int depth) {
        if (depth == R) {
            System.out.println(cur);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (used[i]) continue;

            used[i] = true;
            cur.add(arr[i]);

            permutation(depth + 1);

            // 복원 - 빠뜨리면 다른 경로 탐색 불가
            used[i] = false;
            cur.remove(cur.size() - 1);
        }
    }

    // 조합 - 순서 없음, 중복 없음 (ex. N과 M (2))
    // start로 이미 선택한 원소 재선택 방지
    static void combination(int depth, int start) {
        if (depth == R) {
            System.out.println(cur);
            return;
        }

        for (int i = start; i < N; i++) {
            cur.add(arr[i]);

            combination(depth + 1, i + 1); // i+1 : 중복 선택 방지

            cur.remove(cur.size() - 1);
        }
    }

    // 중복 순열 - 순서 있음, 중복 허용 (ex. N과 M (3))
    static void permutationWithRepetition(int depth) {
        if (depth == R) {
            System.out.println(cur);
            return;
        }

        for (int i = 0; i < N; i++) {
            cur.add(arr[i]);

            permutationWithRepetition(depth + 1); // used 체크 없음

            cur.remove(cur.size() - 1);
        }
    }

    // 중복 조합 - 순서 없음, 중복 허용 (ex. N과 M (4))
    static void combinationWithRepetition(int depth, int start) {
        if (depth == R) {
            System.out.println(cur);
            return;
        }

        for (int i = start; i < N; i++) {
            cur.add(arr[i]);

            combinationWithRepetition(depth + 1, i); // i : 자기 자신 재선택 허용

            cur.remove(cur.size() - 1);
        }
    }

    // 부분집합 - 각 원소 포함 여부 선택
    static void subset(int idx) {
        if (idx == N) {
            System.out.println(cur);
            return;
        }

        // 포함
        cur.add(arr[idx]);
        subset(idx + 1);
        cur.remove(cur.size() - 1);

        // 미포함
        subset(idx + 1);
    }
}
