package com.example.demo.service.impl;

import com.example.demo.model.entities.User;
import com.example.demo.model.service.UserLoginServiceModel;
import com.example.demo.model.service.UserRegisterServiceModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.CurrentUser;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void register(UserRegisterServiceModel map) {
        User user = this.modelMapper.map(map,User.class);
        this.userRepository.save(user);
    }

    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {
        User user = this.userRepository
                .findByUsernameAndPassword(userLoginServiceModel.getUsername(), userLoginServiceModel.getPassword()).orElse(null);
        if (user == null){
            return false;
        }

        this.currentUser.setUsername(userLoginServiceModel.getUsername());

        return true;
    }
}
