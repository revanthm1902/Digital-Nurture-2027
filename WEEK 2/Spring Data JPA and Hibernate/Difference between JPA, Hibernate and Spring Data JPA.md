Difference Between JPA, Hibernate and Spring Data JPA
1. JPA (Java Persistence API)
Definition

JPA is a Java Specification (JSR 338) that defines a standard way to map Java objects to database tables. It is only a specification, not an implementation. Hibernate is one of the most popular implementations of JPA.

Key Points
Standard specification
Not a framework
No actual code implementation
Defines interfaces and annotations
Requires an implementation like Hibernate
Common Annotations
@Entity

@Table

# Difference Between JPA, Hibernate, and Spring Data JPA

## Overview

JPA, Hibernate, and Spring Data JPA are related, but they play different roles:

- JPA defines the standard.
- Hibernate implements the standard.
- Spring Data JPA reduces boilerplate on top of JPA and Hibernate.

## JPA (Java Persistence API)

### Definition

JPA is a Java specification (JSR 338) that defines a standard way to map Java objects to database tables. It is not an implementation by itself.

### Key Points

- Standard specification
- Not a framework
- Does not contain actual runtime code
- Defines interfaces and annotations
- Requires an implementation such as Hibernate

### Common Annotations

- @Entity
- @Table
- @Id
- @Column
- @GeneratedValue

These annotations are defined by JPA.

## Hibernate

### Definition

Hibernate is an ORM framework that implements JPA. It provides the actual functionality needed to communicate with the database and perform CRUD operations.

### Responsibilities

- Object-relational mapping
- SQL generation
- Caching
- Lazy loading
- Transaction management
- Query language support with HQL

### Example

#### Without Hibernate (JDBC)

```java
Connection con = DriverManager.getConnection(...);

PreparedStatement ps =
        con.prepareStatement("INSERT INTO STUDENT VALUES(?,?)");

ps.executeUpdate();
```

This requires more boilerplate code.

#### With Hibernate

```java
session.save(student);
```

This is much shorter and simpler.

## Spring Data JPA

### Definition

Spring Data JPA is a Spring module built on top of JPA. It does not implement JPA itself, but it adds an abstraction layer that removes most of the boilerplate required when using JPA and Hibernate.

### Responsibilities

- Generates repository implementations automatically
- Reduces boilerplate code
- Simplifies transaction handling with @Transactional
- Provides built-in CRUD methods

### Example Repository

```java
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
```

With this interface, we automatically get:

- save()
- findAll()
- findById()
- deleteById()
- count()
- existsById()

No SQL or repository implementation code is needed for these basic operations.

## Layered Architecture

```text
Application
       |
       v
Spring Data JPA
       |
       v
JPA Specification
       |
       v
Hibernate
       |
       v
Database
```

### How the layers work

- Spring Data JPA makes development easier.
- JPA defines the standard.
- Hibernate implements that standard.
- Hibernate communicates with the database.

## Example Comparison

### Using Hibernate Directly

```java
Session session = factory.openSession();

Transaction tx = session.beginTransaction();

session.save(employee);

tx.commit();

session.close();
```

Here you manually open the session, begin the transaction, save the entity, commit, and close the session.

### Using Spring Data JPA

```java
@Autowired
EmployeeRepository repository;

@Transactional
public void addEmployee(Employee employee) {
       repository.save(employee);
}
```

Spring handles the transaction and repository implementation, so the code is much shorter.

