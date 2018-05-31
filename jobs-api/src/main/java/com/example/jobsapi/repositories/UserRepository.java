package com.example.jobsapi.repositories;

import com.example.jobsapi.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
