# BFS / DFS (그래프 탐색)

![BFS vs DFS](https://velog.velcdn.com/images/jh991012/post/044e12ef-ef8b-4974-a2c0-e044af6ce9f3/image.gif)

## [BFS (Breadth First Search : 너비 우선 탐색)](https://en.wikipedia.org/wiki/Breadth-first_search)
루트 노드에서 시작해 인접한 노드를 먼저 탐색하는 방식. 가까운 정점부터 방문하며 **큐**로 구현한다.

## [DFS (Depth First Search : 깊이 우선 탐색)](https://en.wikipedia.org/wiki/Depth-first_search)
루트 노드에서 시작해 한 분기를 끝까지 탐색한 후 다음 분기로 넘어가는 방식. **스택 또는 재귀**로 구현한다.

---

## 선택 기준

| 상황 | 추천 |
|------|------|
| 최단 거리 / 최소 이동, 횟수 | BFS |
| 레벨(깊이) 단위로 처리 필요 | BFS |
| 모든 경로 탐색 / 가능 여부 확인 | DFS |
| 백트래킹 (조합, 순열) | DFS |
| 그래프 사이클 감지 | DFS |
| 위상 정렬 /순서 있는 작업 처리 | DFS |

---

## BFS 핵심

- **Queue** 사용 (ArrayDeque 권장, Stack/LinkedList 쓰지 말 것)
- 방문 처리는 **큐에 넣을 때** 바로 해야 중복 방지
- 시작점이 여러 개면 → 큐에 전부 넣고 시작 (멀티소스 BFS)
- 거리/비용 저장은 `dist[]` 배열 따로 관리

### 자주 하는 실수
- [ ] 방문 처리를 꺼낼 때 하면 → 중복 삽입 → TLE
- [ ] dx/dy 방향 배열 순서 헷갈림 (행=y, 열=x 주의)
- [ ] 인덱스 범위 체크 순서: 범위 먼저, 방문 여부 나중

---

## DFS 핵심

- **재귀** 또는 **Stack** 사용
- 재귀 깊이 주의 (BOJ 기준 대략 10만 이상이면 Stack 방식 고려)
- 백트래킹 시 상태 복원 잊지 말 것 (`visited[i] = false`)

### 자주 하는 실수
- [ ] 재귀 종료 조건 누락 → 스택 오버플로우
- [ ] 방문 배열 복원 안 함 → 다른 경로 탐색 불가
- [ ] 전역 변수로 결과 저장 시 초기화 누락
