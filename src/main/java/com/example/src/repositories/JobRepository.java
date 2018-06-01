package com.example.src.repositories;

import com.example.src.models.Job;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobRepository extends CrudRepository<Job, Long> {

    List<Job> findByUserId(int userId);
}
