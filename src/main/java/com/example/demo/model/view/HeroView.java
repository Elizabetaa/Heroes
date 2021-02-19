package com.example.demo.model.view;

public class HeroView {

    private Long id;
    private String heroName;
    private String imgURL;

    public HeroView() {
    }

    public Long getId() {
        return id;
    }

    public HeroView setId(Long id) {
        this.id = id;
        return this;
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
