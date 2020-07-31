package tim.project.covidtracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    @RequestMapping("/add")
    public int sum (@RequestParam(defaultValue = "0") int a,@RequestParam(defaultValue = "0") int b){
        return a+b;
    }
    @RequestMapping("/hello")
    public String helloWorld(@RequestParam(defaultValue = "world") String name) {
        return "hello " + name;
    }


}
