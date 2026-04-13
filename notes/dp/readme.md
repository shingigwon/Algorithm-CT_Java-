# [DP (Dynamic Programming)](https://en.wikipedia.org/wiki/Dynamic_programming)

큰 문제를 작은 부분 문제로 나눠 풀고, 결과를 저장해 중복 계산을 피하는 방식.

---

## 적용 상황

| 상황 | 키워드 |
|------|--------|
| 최댓값 / 최솟값 | 최대 이익, 최소 비용 |
| 경우의 수 | ~가지, ~방법의 수 |
| 가능 여부 | ~할 수 있는가 |
| 최장 / 최단 수열 | LIS, LCS |

---

## Top-down vs Bottom-up

### Top-down (메모이제이션)
- 재귀로 구현, 계산한 값을 `memo[]` 에 저장
- 필요한 부분만 계산 → 불필요한 연산 생략 가능
- 재귀 깊이 주의 (스택 오버플로우)

```java
static int[] memo;

static int topDown(int n) {
    if (n <= 1) return n;
    if (memo[n] != -1) return memo[n]; // 이미 계산한 값이면 바로 반환

    return memo[n] = topDown(n - 1) + topDown(n - 2);
}
```

### Bottom-up (타뷸레이션)
- 반복문으로 구현, 작은 문제부터 순서대로 채워나감
- 재귀 오버헤드 없음 → 일반적으로 더 빠름
- 채우는 순서가 중요

```java
static int bottomUp(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0; dp[1] = 1;

    for (int i = 2; i <= n; i++)
        dp[i] = dp[i - 1] + dp[i - 2];

    return dp[n];
}
```

---

## 패턴별 정리

### 1. 1D DP (선형)
이전 값(들)을 이용해 현재 값 결정
`dp[i] = f(dp[i-1], dp[i-2], ...)`
ex. 계단 오르기, 연속합, 1로 만들기

### 2. 2D DP (격자)
2차원 배열에서 이전 행/열 이용
`dp[i][j] = f(dp[i-1][j], dp[i][j-1])`
ex. 최소 비용 경로

### 3. 배낭 문제 (Knapsack)
무게 제한 내 최대 가치
- 0/1 배낭 : 각 아이템 1번만 사용 → `dp[i-1]` 참조
- 완전 배낭 : 각 아이템 무제한 → `dp[i]` 참조

### 4. [LIS (최장 증가 부분 수열)](https://en.wikipedia.org/wiki/Longest_increasing_subsequence)
`dp[i]` = i번째에서 끝나는 LIS 길이
- O(N²) : `dp[i] = max(dp[j] + 1)` (j < i, arr[j] < arr[i])
- O(N log N) : 이분탐색 활용

### 5. [LCS (최장 공통 부분 수열)](https://en.wikipedia.org/wiki/Longest_common_subsequence)
`dp[i][j]` = s1[0..i], s2[0..j]의 LCS 길이
- 같으면 : `dp[i][j] = dp[i-1][j-1] + 1`
- 다르면 : `dp[i][j] = max(dp[i-1][j], dp[i][j-1])`

### 6. 구간 DP
구간 [i, j]의 최적값을 중간점 k로 분할
`dp[i][j] = min(dp[i][k] + dp[k+1][j] + cost)`
ex. 행렬 연쇄 곱셈, 팰린드롬 분할

### 7. 비트마스크 DP
방문 상태를 비트로 표현
`dp[visited][cur] = min(dp[visited | (1<<next)][next] + cost)`
ex. TSP (외판원 순회)

### 8. DP + 그래프 ([플로이드-워셜](https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm))
모든 정점 쌍의 최단 거리
`dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j])`
음수 간선 가능, O(V³)

### 9. Tree DP
트리에서 서브트리 값을 누적
`dp[node][0]` = 선택 안 함, `dp[node][1]` = 선택

### 10. 문자열 편집 거리
두 문자열을 변환하는 최소 연산 수
- 같으면 : `dp[i][j] = dp[i-1][j-1]`
- 다르면 : `dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1`

---

## 핵심

- **점화식 세우기가 전부** — 점화식만 맞으면 구현은 단순
- 초기값 설정 실수 주의 (`0` vs `INF` vs `-INF`)
- Top-down은 구현이 직관적, Bottom-up은 성능이 우수

### 자주 하는 실수
- [ ] 점화식 인덱스 범위 초과
- [ ] 초기값 잘못 설정 (최솟값 구할 때 0으로 초기화)
- [ ] Bottom-up 순서 잘못 설정 (앞에서부터 vs 뒤에서부터)
- [ ] 메모이제이션 배열 초기화 누락 (`Arrays.fill(memo, -1)`)
