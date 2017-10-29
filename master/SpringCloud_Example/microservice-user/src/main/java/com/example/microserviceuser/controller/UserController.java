package com.example.microserviceuser.controller;
import com.example.microserviceuser.repository.UserRepository;
import com.example.microserviceuser.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findUser")
    public User findUser(User user) {
        return userRepository.findUser(user);
    }

}
