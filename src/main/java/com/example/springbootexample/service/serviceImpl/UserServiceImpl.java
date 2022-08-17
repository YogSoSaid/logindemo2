package com.example.springbootexample.service.serviceImpl;

import com.example.springbootexample.domain.User;
import com.example.springbootexample.repository.UserDao;
import com.example.springbootexample.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User loginService(String uname, String password) {
        User user = userDao.findByUnameAndPassword(uname, password);
        if(user != null){
            user.setPassword("");
        }
        return user;

    }

    @Override
    public User registService(User user) {
        if(userDao.findByUname(user.getUname())!=null){
            return null;
        }else{
            User newUser = userDao.save(user);
            if(newUser != null){
                newUser.setPassword("");
            }
            return newUser;
        }
    }
}
