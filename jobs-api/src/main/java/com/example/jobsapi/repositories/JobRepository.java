package com.example.jobsapi.repositories;

import com.example.jobsapi.models.Job;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobRepository extends CrudRepository<Job, Long> {

    List<Job> findByUserId(int userId);
}
