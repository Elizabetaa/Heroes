package com.example.demo.model.entities;

import com.example.demo.model.entities.enums.HeroClass;

import javax.persistence.*;

@Entity
@Table(name = "heroes")
public class Hero extends BaseEntity{
    private String heroName;
    private HeroClass heroClass;
    private int heroLevel;

    public Hero() {
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getHeroName() {
        return heroName;
    }

    public Hero setHeroName(String heroName) {
        this.heroName = heroName;
        return this;
    }

    @Enumerated(value = EnumType.STRING)
    public HeroClass getHeroClass() {
        return heroClass;
    }

    public Hero setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
        return this;
    }

    @Column(name = "level", nullable = false)
    public int getHeroLevel() {
        return heroLevel;
    }

    public Hero setHeroLevel(int heroLevel) {
        this.heroLevel = heroLevel;
        return this;
    }
}
