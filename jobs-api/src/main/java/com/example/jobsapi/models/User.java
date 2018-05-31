package com.example.jobsapi.models;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "AGE")
    private int age;

    @Column(name = "OCCUPATION")
    private String occupation;

    @Column(name = "ETHNICITY")
    private String ethnicity;

    @Column(name = "INTERESTS")
    private String interests;

    @Column(name = "PROFILE")
    private String profile;
}