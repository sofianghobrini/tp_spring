package com.example.tp_spring_ghobrini.controller;

import com.example.tp_spring_ghobrini.modele.User;
import com.example.tp_spring_ghobrini.exception.UserNotFoundException;
import com.example.tp_spring_ghobrini.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UserController {
    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping
    List<User> all() {
        return (List<User>) repository.findAll();
    }
    // end::get-aggregate-root[]


    @PostMapping
    User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    // Single item

    @GetMapping("/id")
    User one(@RequestParam (required = false) Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping
    User replaceEmployee(@RequestBody User newUser, @PathVariable Long id) {

        return repository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setRole(newUser.getRole());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    return repository.save(newUser);
                });
    }

    @DeleteMapping
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
