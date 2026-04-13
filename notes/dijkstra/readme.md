# [다익스트라 (Dijkstra)](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm)

하나의 출발점에서 모든 정점까지 최단 거리를 구하는 알고리즘. **음수 간선 불가**. O((V+E) log V)

<img width="580" height="326" alt="image" src="https://github.com/user-attachments/assets/38991672-04cd-4910-a783-907b538a55a7" />

---

## 적용 상황

| 상황 | 키워드 |
|------|--------|
| 단일 출발점 최단 거리 | 최소 비용, 최단 경로 |
| 가중치 있는 그래프 탐색 | 간선에 비용 존재 |
| 음수 간선 없는 최단경로 | 음수 없을 때 (있으면 [벨만-포드](../bellman_ford/README.md)) |

---

## 핵심

- **우선순위 큐 (최소힙)** 사용 — `PriorityQueue<int[]>` `{거리, 노드}` 순
- 방문 배열 대신 `dist[]` 로 갱신 여부 판단
- 꺼낼 때 `dist[node] < cost` 면 오래된 정보 → skip
- 시작점 `dist[start] = 0`, 나머지 `INF` 로 초기화

### 자주 하는 실수
- [ ] 음수 간선에 적용 → 벨만포드 써야 함
- [ ] 꺼낼 때 오래된 정보 skip 누락 → 잘못된 갱신
- [ ] `INF` 값 더할 때 오버플로우 (`Integer.MAX_VALUE / 2` 사용)
