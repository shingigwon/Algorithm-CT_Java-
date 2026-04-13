# [이분탐색 (Binary Search)](https://en.wikipedia.org/wiki/Binary_search)

정렬된 배열에서 탐색 범위를 절반씩 줄여가며 값을 찾는 방식. O(log N).

![다운로드](https://github.com/user-attachments/assets/9f5b11c2-5915-42bf-ad2b-7cbc594419c3)


---

## 적용 상황

| 상황 | 키워드 |
|------|--------|
| 정렬된 배열에서 값 탐색 | 특정 값 존재 여부 |
| 최솟값 / 최댓값 최적화 | ~의 최솟값, 최대 ~를 구하라 |
| 특정 조건을 만족하는 경계 찾기 | 처음으로 조건 만족하는 위치 |
| 파라메트릭 서치 | 조건 함수로 가능/불가능 판단 |

---

## 핵심

- **정렬 선행 필수**
- `mid = left + (right - left) / 2` — 오버플로우 방지
- `lower_bound` : 조건 만족하는 **첫 번째** 위치
- `upper_bound` : 조건 만족하는 **마지막 다음** 위치
- 파라메트릭 서치 : "~가 가능한가?" 함수로 바꿔서 이분탐색

### 자주 하는 실수
- [ ] `left <= right` vs `left < right` 조건 혼동
- [ ] `mid` 계산 시 int 오버플로우
- [ ] 경계값 처리 (`left = mid + 1` vs `right = mid`)
