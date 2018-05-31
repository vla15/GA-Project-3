package com.example.jobsapi.repositories;

import com.example.jobsapi.models.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long> {

    Iterable<Job> findAllByUserId(int userId);
}
