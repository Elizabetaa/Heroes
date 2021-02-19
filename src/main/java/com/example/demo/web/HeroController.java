package com.example.demo.web;

import com.example.demo.model.binding.HeroCreateBindingModel;
import com.example.demo.model.service.HeroCreateServiceModel;
import com.example.demo.security.CurrentUser;
import com.example.demo.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("heroes")
public class HeroController {

    private final ModelMapper modelMapper;
    private final HeroService heroService;
    private final CurrentUser currentUser;


    public HeroController(ModelMapper modelMapper, HeroService heroService, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.heroService = heroService;
        this.currentUser = currentUser;
    }

    @GetMapping("/create")
    public String create(Model model) {
        if (currentUser.isAnonymous()) {
            return "index";
        }
        if (!model.containsAttribute("heroCreateBindingModel")) {
            model.addAttribute("heroCreateBindingModel", new HeroCreateBindingModel());
        }

        return "create-hero";
    }

    @PostMapping("/create")
    public String createConfirm(@Valid HeroCreateBindingModel heroCreateBindingModel,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("heroCreateBindingModel", heroCreateBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.heroCreateBindingModel",bindingResult);

            return "redirect:create";
        }

        this.heroService.create(this.modelMapper.map(heroCreateBindingModel, HeroCreateServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model){
        model.addAttribute("hero",this.heroService.findHero(id));
        return "details-hero";
    }
}
