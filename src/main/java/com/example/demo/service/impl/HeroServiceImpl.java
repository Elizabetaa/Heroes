package com.example.demo.service.impl;

import com.example.demo.model.binding.HeroCreateBindingModel;
import com.example.demo.model.entities.Hero;
import com.example.demo.model.service.HeroCreateServiceModel;
import com.example.demo.model.view.HeroView;
import com.example.demo.repository.HeroRepository;
import com.example.demo.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<HeroView> findAll() {
        List<HeroView> heroViews = new ArrayList<>();
        this.heroRepository.findAll().forEach(h -> {
            HeroView heroView = this.modelMapper.map(h,HeroView.class);
            switch (h.getHeroClass()){
                case WARRIOR:
                    heroView.setImgURL("/img/warrior.jpg");
                    break;
                case ARCHER:
                    heroView.setImgURL("/img/archer.jpg");
                    break;
                case MAGE:
                    heroView.setImgURL("/img/mage.jpg");
                    break;
            }
            heroViews.add(heroView);
        });
        return heroViews;
    }

    @Override
    public HeroCreateServiceModel findHero(Long id) {
        return this.modelMapper.map(this.heroRepository.findById(id).orElse(null),HeroCreateServiceModel.class);
    }

    @Override
    public void delete(HeroCreateServiceModel heroCreateBindingModel) {
        this.heroRepository.delete(this.modelMapper.map(heroCreateBindingModel, Hero.class));
    }

}
