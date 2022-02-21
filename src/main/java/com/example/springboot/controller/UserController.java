package com.example.springboot.controller;

import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    private UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<Iterable<User>> getAll()
    {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable ("id") Long id)
    {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("?name")
    public ResponseEntity<Iterable<User>> getAllUsersByName(@RequestParam(value = "name", required = true) String name)
    {
        return ResponseEntity.ok(userService.getUsersByName(name));
    }

    @PostMapping()
    public void save(@RequestBody User user)
    {
        userService.save(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody User user)
    {
        userService.updateUserById(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserFromDB(@PathVariable("id") Long id)
    {
        userService.deleteUserById(id);
    }


}
