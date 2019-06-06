package com.shiro.shiro_00.service;

import com.shiro.shiro_00.entity.User;

public interface UserService {
    public User findByName(String name);
}
