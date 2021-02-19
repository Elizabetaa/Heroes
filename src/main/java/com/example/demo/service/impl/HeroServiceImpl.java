package com.example.demo.service.impl;

import com.example.demo.model.entities.Hero;
import com.example.demo.model.service.HeroCreateServiceModel;
import com.example.demo.repository.HeroRepository;
import com.example.demo.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class HeroServiceImpl implements HeroService {
    private final ModelMapper modelMapper;
    private final HeroRepository heroRepository;

    public HeroServiceImpl(ModelMapper modelMapper, HeroRepository heroRepository) {
        this.modelMapper = modelMapper;
        this.heroRepository = heroRepository;
    }

    @Override
    public void create(HeroCreateServiceModel heroCreateServiceModel) {
        Hero hero = this.modelMapper.map(heroCreateServiceModel, Hero.class);
        this.heroRepository.save(hero);

    }
}
