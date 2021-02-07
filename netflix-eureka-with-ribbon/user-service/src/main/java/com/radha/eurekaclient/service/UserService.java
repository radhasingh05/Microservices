package com.radha.eurekaclient.service;

import com.radha.eurekaclient.core.User;
import com.radha.eurekaclient.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public Optional<User> findById(Integer integer){
        return userRepository.findById(integer);
    }

    public void deleteById(Integer integer){
        userRepository.deleteById(integer);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
