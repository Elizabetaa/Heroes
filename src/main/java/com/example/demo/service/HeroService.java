package com.example.demo.service;

import com.example.demo.model.binding.HeroCreateBindingModel;
import com.example.demo.model.entities.Hero;
import com.example.demo.model.service.HeroCreateServiceModel;
import com.example.demo.model.view.HeroView;

import java.util.List;

public interface HeroService {
    void create(HeroCreateServiceModel heroCreateServiceModel);

    List<HeroView> findAll();

    HeroCreateServiceModel findHero(Long id);

    void delete(HeroCreateServiceModel heroCreateBindingModel);
}
