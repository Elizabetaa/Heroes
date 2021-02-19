package com.example.demo.model.view;

public class HeroView {
    private String heroName;
    private String imgURL;

    public HeroView() {
    }

    public String getHeroName() {
        return heroName;
    }

    public HeroView setHeroName(String heroName) {
        this.heroName = heroName;
        return this;
    }

    public String getImgURL() {
        return imgURL;
    }

    public HeroView setImgURL(String imgURL) {
        this.imgURL = imgURL;
        return this;
    }
}
