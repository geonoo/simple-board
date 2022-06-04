# simple-board

간단한 게시판 만들기!

### API 명세

| 기능        | Method | URL     | 요청   | 반환                    |
|-----------|------|---------|------|-----------------------|
| 전체 글 목록 조회 | GET  | /api/post | -    | List&#60;Post&#62;    |
| 게시글 작성    | POST | /api/post | Post | Post                  |
| 게시글 조회    | GET  | /api/post/{id} | -    | Post                  |
| 게시글 수정    | PUT  | /api/post/{id} | Post | Post                  |
| 게시글 삭제    | DELETE | /api/post/{id} | -    | id                    |
| 댓글 목록 조회  | GET  | /api/comment | -    | List&#60;Comment&#62; |
| 댓글 작성     | POST | /api/comment | Comment | Comment               |
| 댓글 수정     | PUT  | /api/comment/{id} | Comment | Comment               |
| 댓글 삭제     | DELETE | /api/comment/{id} | -    | id                    |


### 2022-06-03 - 일부 완성 / 정리 해야할...
- 전체 글 목록 조회
- 게시글 작성
- 게시글 조회
- 게시글 수정
- 게시글 삭제

#### JPA

#### Controller
- @RestController
- @RequiredArgsConstructor

#### Domain
- @Getter
- @Entity
- @NoArgsConstructor
- @Id
- @GeneratedValue(strategy = GenerationType.IDENTITY)
- @Column(nullable = false)

#### Repository
- JpaRepository

#### Setvice
- @RequiredArgsConstructor
- @Service
- @Transactional

#### BaseTimeEntity
- @MappedSuperclass
- @EntityListeners(AuditingEntityListener.class)
- @CreatedDate
- @LastModifiedDate

