package com.example.src.models;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "JOBS")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "JOB_ID")
    private int jobId;

    public Job (int userId, int jodId) {
        this.userId = userId;
        this.jobId = jobId;
    }
}
