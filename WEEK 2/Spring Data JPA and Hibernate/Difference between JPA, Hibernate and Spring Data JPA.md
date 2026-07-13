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

@Id

@Column

@GeneratedValue

These annotations are defined by JPA.

2. Hibernate
Definition

Hibernate is an ORM Framework that implements JPA. It provides the actual functionality to communicate with the database and perform CRUD operations.

Responsibilities
Object-Relational Mapping
SQL generation
Caching
Lazy Loading
Transaction Management
Query Language (HQL)
Example

Without Hibernate (JDBC)

Connection con = DriverManager.getConnection(...);

PreparedStatement ps =
con.prepareStatement("INSERT INTO STUDENT VALUES(?,?)");

ps.executeUpdate();

Lots of code.

With Hibernate

session.save(student);

Just one line.

3. Spring Data JPA
Definition

Spring Data JPA is a Spring module built on top of JPA. It does not implement JPA itself but provides an additional abstraction that removes most of the boilerplate code required when using JPA/Hibernate. It also simplifies transaction management.

Responsibilities
Generates repository implementations automatically
Reduces boilerplate code
Automatically manages transactions (with @Transactional)
Provides built-in CRUD methods

Example Repository

@Repository
public interface StudentRepository
        extends JpaRepository<Student,Integer>{

}

Now we automatically get:

save()

findAll()

findById()

deleteById()

count()

existsById()

without writing SQL.

Visual Architecture

Application

       │

       ▼

Spring Data JPA

       │

       ▼

JPA Specification

       │

       ▼

Hibernate

       │

       ▼

Database

Think of it like layers:

Spring Data JPA makes development easier.
JPA defines the standard.
Hibernate implements that standard.
Hibernate communicates with the database.
Example Comparison
Using Hibernate

You manually manage the session and transaction:

Session session = factory.openSession();

Transaction tx = session.beginTransaction();

session.save(employee);

tx.commit();

session.close();

As shown in your Deep Skilling notes, you explicitly open a session, begin a transaction, save the entity, commit, and close the session.

Using Spring Data JPA
@Autowired
EmployeeRepository repository;

@Transactional
public void addEmployee(Employee employee){

    repository.save(employee);

}

Spring automatically manages the transaction and the repository implementation, so the code is much shorter