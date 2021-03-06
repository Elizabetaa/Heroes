package com.example.demo.model.service;

import com.example.demo.model.entities.enums.HeroClass;

public class HeroCreateServiceModel {
    private Long id;
    private String heroName;
    private HeroClass heroClass;
    private int heroLevel;

    public HeroCreateServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public HeroCreateServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getHeroName() {
        return heroName;
    }

    public HeroCreateServiceModel setHeroName(String heroName) {
        this.heroName = heroName;
        return this;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public HeroCreateServiceModel setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
        return this;
    }

    public int getHeroLevel() {
        return heroLevel;
    }

    public HeroCreateServiceModel setHeroLevel(int heroLevel) {
        this.heroLevel = heroLevel;
        return this;
    }
}
