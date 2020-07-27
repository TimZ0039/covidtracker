package tim.project.covidtracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String helloWorld(){
        return "hello world";
    }
//    @RequestMapping("/error")
//    public String error(){
//     return "you have encountered an error";
//    }

}
