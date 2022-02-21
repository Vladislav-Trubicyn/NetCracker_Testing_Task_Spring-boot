package com.example.springboot.service;

import com.example.springboot.entity.User;
import com.example.springboot.repository.UserRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAll()
    {
        return userRepository.findAll();
    }

    public User getUserById(Long id)
    {
        return userRepository.findById(id).get();
    }

    public void save(User user)
    {
        userRepository.save(user);
    }

    public void updateUserById(Long id, User user)
    {
        User userFromDB = userRepository.findById(id).get();
        if(!Strings.isEmpty(user.getUserName()))
        {
            userFromDB.setUserName(user.getUserName());
        }
        if(!Strings.isEmpty(user.getLastName()))
        {
            userFromDB.setLastName(user.getLastName());
        }
        if(!Strings.isEmpty(user.getEmail()))
        {
            userFromDB.setEmail(user.getEmail());
        }
        userRepository.save(userFromDB);
    }

    public void deleteUserById(Long id)
    {
        userRepository.deleteById(id);
    }

    public Iterable<User> getUsersByName(String name)
    {
        return userRepository.findAllByUserName(name);
    }
}
