package com.example.usersapi.controlleres;

import com.example.usersapi.models.User;
import com.example.usersapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userRepository.findOne(userId);
    }

    @GetMapping("/search")
    public Iterable<User> getUsersByParams(@RequestParam("filter") String filter, @RequestParam("data") String value) {
        switch(filter) {
            case "firstName":
                return userRepository.findByFirstName(value);
            case "lastName":
                return userRepository.findByLastName(value);
            case "interests":
                return userRepository.findByInterests(value);
            case "occupation":
                return userRepository.findByOccupation(value);
            case "age":
                return userRepository.findByAge(value);
            default: return userRepository.findAll();
        }
    }

    @DeleteMapping("/{userId}")
    public HttpStatus deleteUserById(@PathVariable Long userId) {
        User userToDelete = userRepository.findOne(userId);
        userRepository.delete(userToDelete);
        return HttpStatus.OK;
    }

    @PostMapping("/")
    public User addNewUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{userId}")
    public User updateUserById(@RequestBody User newUser, @PathVariable Long userId) {
        User userFromDb = userRepository.findOne(userId);

        userFromDb.setFirstName(newUser.getFirstName());
        userFromDb.setLastName(newUser.getLastName());
        userFromDb.setAge(newUser.getAge());
        userFromDb.setEthnicity(newUser.getEthnicity());
        userFromDb.setOccupation(newUser.getOccupation());
        userFromDb.setInterests(newUser.getInterests());
        userFromDb.setProfile(newUser.getProfile());

        return userRepository.save(userFromDb);
    }
}
