package com.example.springboot.controller;

import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import org.springframework.web.bind.annotation.*;

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
    public String getAll()
    {
        return String.format(userService.getAll().toString());
    }

    @GetMapping("/{id}")
    public String get(@PathVariable ("id") int id)
    {
        return userService.getUserById(id).toString();
    }

    @PostMapping()
    public void save(@RequestBody User user)
    {
        userService.save(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") int id, @RequestBody User user)
    {
        userService.updateUserById(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserFromDB(@PathVariable("id") int id)
    {
        userService.deleteUserById(id);
    }
}
