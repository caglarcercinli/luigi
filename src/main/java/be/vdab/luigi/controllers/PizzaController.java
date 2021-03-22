package be.vdab.luigi.controllers;

import be.vdab.luigi.domain.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
@RequestMapping("pizzas")
public class PizzaController {
    private final Pizza[] pizzas={
            new Pizza(1,"prosciutto", BigDecimal.valueOf(4),true),
            new Pizza(2,"margherita", BigDecimal.valueOf(5),false),
            new Pizza(3,"calzone", BigDecimal.valueOf(4),false)
    };
    @GetMapping
    public ModelAndView pizzas(){
        return new ModelAndView("pizzas","pizzas",pizzas);
    }
}
