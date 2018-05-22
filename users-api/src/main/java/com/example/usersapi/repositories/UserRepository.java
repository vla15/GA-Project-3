package com.example.usersapi.repositories;

import com.example.usersapi.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("Select u FROM User u where u.firstName = :value")
    Iterable<User> findByFirstName(@Param("value") String value);

    @Query("Select u FROM User u where u.lastName = :value")
    Iterable<User> findByLastName(@Param("value") String value);

    @Query("Select u FROM User u where u.age = :value")
    Iterable<User> findByAge(@Param("value") String value);

    @Query("Select u FROM User u where u.occupation= :value")
    Iterable<User> findByOccupation(@Param("value") String value);

    @Query("Select u FROM User u where u.interests = :value")
    Iterable<User> findByIntersts(@Param("value") String value);

    @Query("Select u FROM User u where u.ethnicity = :value")
    Iterable<User> findByEthnicity(@Param("value") String value);
}
