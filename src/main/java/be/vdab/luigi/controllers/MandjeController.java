package be.vdab.luigi.controllers;

import be.vdab.luigi.services.PizzaService;
import be.vdab.luigi.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("mandje")
public class MandjeController {
private final Mandje mandje;
private final PizzaService pizzaService;

    public MandjeController(Mandje mandje, PizzaService pizzaService) {
        this.mandje = mandje;
        this.pizzaService = pizzaService;
    }

    @PostMapping("{id}")
    public String voegToe(@PathVariable long id){
        mandje.voegToe(id);
        return "redirect:/mandje";
    }


    @GetMapping
    public ModelAndView mandje(){
        return new ModelAndView("mandje","pizzas", pizzaService.findByIds(mandje.getIds()));
    }


}
