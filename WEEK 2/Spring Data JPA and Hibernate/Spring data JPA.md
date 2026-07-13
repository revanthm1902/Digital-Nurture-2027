# Spring Data JPA

## Definition

Spring Data JPA is a Spring module built on top of JPA. It does not implement JPA itself, but it adds an abstraction that removes most of the boilerplate code required when using JPA and Hibernate. It also simplifies transaction management.

## Responsibilities

- Generates repository implementations automatically
- Reduces boilerplate code
- Manages transactions with @Transactional
- Provides built-in CRUD methods

## Example Repository

```java
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
```

With this interface, you automatically get:

- save()
- findAll()
- findById()
- deleteById()
- count()
- existsById()

This works without writing SQL for basic CRUD operations.
