package com.example.demo.service;

import com.example.demo.model.service.UserLoginServiceModel;
import com.example.demo.model.service.UserRegisterServiceModel;

public interface UserService {
    void register(UserRegisterServiceModel map);

    boolean login(UserLoginServiceModel userLoginServiceModel);
}
