package com.example.ToDoList.service;

import com.example.ToDoList.Security.CustomUserDetails;
import com.example.ToDoList.model.User;
import com.example.ToDoList.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepositoryObject;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userObject = userRepositoryObject.findByName(username);
        if (userObject == null){
            throw new UsernameNotFoundException("User not found!..");
        }
        return new CustomUserDetails(userObject);
    }
}
