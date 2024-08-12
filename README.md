# SpringBootApplication
Spring Boot Application created while learning spring concepts from Madan Reddy through his udemy course

## Spring Data JPA
    - ORM Frameworks like hibernate, MyBatis
    - RowMappers become redundant
    - makes developers life easy

> Repository is the central interface of Spring Data JPA. Its a marker interface.
> Repository is present in spring-data  -commons jar

Difference between CrudRepository and ListCrudRepository is findAll() returns an Iterable<T> in the first and List<T> in the latter.

JpaRepository extends ListCrudRepository and ListPagingAndSortingRepository and is present in Spring-data-jpa jar.

Derived Query methods eg. findByEmailAndLastName(String email, String lastName). Here, email and lastName are fields of the entity.

