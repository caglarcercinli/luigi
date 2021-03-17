package be.vdab.luigi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public String index(){
        var morgenOfMiddag = LocalTime.now().getHour() <12 ? "morgen": "middag";
        return "<!doctype html><html><html><title>Hallo</title>Goede "
                +morgenOfMiddag+"</body></html>";
    }

}
