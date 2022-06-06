# simple-board

간단한 게시판 만들기!

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

#### Exception
 - @RestControllerAdvice
 - @ExceptionHandler

