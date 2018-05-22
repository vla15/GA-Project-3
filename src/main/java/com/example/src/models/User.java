package com.example.src.models;


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

    public User(String firstName, String lastName, int age, String occupation, String ethnicity, String interests, String profile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.occupation = occupation;
        this.ethnicity = ethnicity;
        this.interests = interests;
        this.profile = profile;
    }
}
