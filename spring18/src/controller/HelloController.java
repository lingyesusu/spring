package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {
    @RequestMapping("/hello.action")
    public String index() {
        return "hello";
    }
    
    @RequestMapping("/myJsp.action")
    public String myJsp() {
        return "MyJsp";
    }
    
}
