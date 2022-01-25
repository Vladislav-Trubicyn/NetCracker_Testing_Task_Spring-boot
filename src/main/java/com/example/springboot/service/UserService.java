package com.example.springboot.service;

import com.example.springboot.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    List<User> userList = new ArrayList<>(
            Arrays.asList(
                    new User(1,"Vladislav","Trubicyn","maile"),
                    new User(2, "Chiki", "Briki","iVDamke"),
                    new User(3, "Anton", "Ahmetov","donsk@mylu.no"),
                    new User(4, "Max", "Ahirov","dfsd")
            )
    );

    public List<User> getAll()
    {
        return userList;
    }

    public Optional<User> getUserById(int id)
    {
        return userList.stream().filter(user -> user.getId() == id).findFirst();
    }

    public void save(User user)
    {
        user.setId(userList.size()+1);
        userList.add(user);
    }

    public void updateUserById(int id, User user)
    {
        User userFromDB = getUserById(id).get();
        userFromDB.setUserName(user.getUserName());
        userFromDB.setLastName(user.getLastName());
        userFromDB.setEmail(user.getEmail());
        userList.set(id, user);
    }

    public void deleteUserById(int id)
    {
        userList.remove(id-1);

        for(int i = 0; i < userList.size(); i++)
        {
            userList.get(i).setId(i+1);
        }
    }

}
