package com.example.demo.service.impl;

import com.example.demo.model.entities.User;
import com.example.demo.model.service.UserRegisterServiceModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void register(UserRegisterServiceModel map) {
        User user = this.modelMapper.map(map,User.class);
        this.userRepository.save(user);
    }
}
