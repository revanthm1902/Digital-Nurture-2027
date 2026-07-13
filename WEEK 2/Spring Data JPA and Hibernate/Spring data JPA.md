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