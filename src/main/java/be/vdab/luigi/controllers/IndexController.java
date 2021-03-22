package be.vdab.luigi.controllers;

import be.vdab.luigi.domain.Adres;
import be.vdab.luigi.domain.Persoon;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public ModelAndView index(){
        var morgenOfMiddag = LocalTime.now().getHour() < 12 ? "morgen" : "middag";
        var modelAndView = new ModelAndView("index","moment",morgenOfMiddag);
        modelAndView.addObject("zaakvoerder",
                new Persoon("Luigi","Peperone",7,true, LocalDate.of(1966,1,1),
                        new Adres("Grote Markt","3",9700,"oudenaarde")));
        return modelAndView;
        //return new ModelAndView("index","moment",morgenOfMiddag);
        //return new ModelAndView("index","kinderen",8);
    }

}
