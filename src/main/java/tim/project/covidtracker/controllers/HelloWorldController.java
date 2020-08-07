package tim.project.covidtracker.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
    @GetMapping("/test")
    public String test(@RequestParam(defaultValue = "ca") String states){
        String url = "https://api.covidtracking.com/v1/states/" + states + "/current.json";
        RestTemplate covidState = new RestTemplate();
        String result = covidState.getForObject(url,String.class);
        return result;
    }

}



