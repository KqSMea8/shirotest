package com.shiro.shiro_00.service;

import com.shiro.shiro_00.entity.User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserServiceImpl implements UserService {
    Map<String, User> map = new ConcurrentHashMap<>(300);
    @Override
    public User findByName(String name) {
        User user = map.get(name);
        return user;
    }
}
