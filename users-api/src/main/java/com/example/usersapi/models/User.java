package com.example.usersapi.models;


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

    @Column(name = "EMAIL")
    private String ethnicity;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "INTERESTS")
    private String interests;

    @Column(name = "PROFILE")
    private String profile;
}
