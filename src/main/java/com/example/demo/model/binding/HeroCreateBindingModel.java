package com.example.demo.model.binding;

import com.example.demo.model.entities.enums.HeroClass;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HeroCreateBindingModel {
    private String heroName;
    private HeroClass heroClass;
    private int heroLevel;

    public HeroCreateBindingModel() {
    }

    @NotBlank(message = "Hero name cannot be empty")
    @Size(min = 2, max = 20, message = "Hero name must between two and twenty symbols!")
    public String getHeroName() {
        return heroName;
    }

    public HeroCreateBindingModel setHeroName(String heroName) {
        this.heroName = heroName;
        return this;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public HeroCreateBindingModel setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
        return this;
    }
    @NotNull(message = "Hero level cannot be empty")
    @Min(value = 0,message = "Level must be positive!")
    public int getHeroLevel() {
        return heroLevel;
    }

    public HeroCreateBindingModel setHeroLevel(int heroLevel) {
        this.heroLevel = heroLevel;
        return this;
    }
}
