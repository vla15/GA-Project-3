package com.example.jobsapi.controllers;

import com.example.jobsapi.models.Job;
import com.example.jobsapi.repositories.JobRepository;
import com.example.jobsapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class JobController {
    @Autowired
    private UserRepository userRepository;
    private JobRepository jobRepository;

    @PostMapping("/apply")
    public Job addApplication(@RequestBody Job jobApplication) {
        return jobRepository.save(jobApplication);
    }

    @GetMapping("/{userId}")
    public Iterable<Job> getJobsAppliedTo(@PathVariable int userId) {
        return jobRepository.findAllByUserId(userId);
    }
}
