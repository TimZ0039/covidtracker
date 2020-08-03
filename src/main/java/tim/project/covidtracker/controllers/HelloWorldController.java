package tim.project.covidtracker.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    @GetMapping("/add")
    public Output sum (@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b){
        Output output = new Output();
        output.a = a;
        output.b = b;
        output.answer = a +b;
        return output;
    }
    @GetMapping("/hello")
    public String helloWorld(@RequestParam(defaultValue = "world") String name) {
        return "hello " + name;
    }
    @PostMapping("/multiply")
    public Output multiply (@RequestBody InputNumbers input){
        Output output = new Output();
        output.a = input.a;
        output.b = input.b;
        output.answer = input.a * input.b;
        return output;
    }

}



