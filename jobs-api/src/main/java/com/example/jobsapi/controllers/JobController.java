package com.example.jobsapi.controllers;

import com.example.jobsapi.models.Job;
import com.example.jobsapi.repositories.JobRepository;
import com.example.jobsapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @PostMapping("/apply")
    public Job addNewApplication(@RequestBody Job job) {
        return jobRepository.save(job);
    }

    @GetMapping("/{userId}")
    public Iterable<Job> getJobsAppliedTo(@PathVariable int userId) {
        return jobRepository.findByUserId(userId);
    }
}
