package com.example.microserviceuser.repository;

import com.example.microserviceuser.vo.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserRepository {


    public User findUser(User user){

        User user1=new User();
        user1.setId("1");
        user1.setName("张三");
        user1.setAge(20);
        return user1;
    }
}
