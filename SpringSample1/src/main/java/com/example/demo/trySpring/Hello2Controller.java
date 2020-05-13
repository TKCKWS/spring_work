package com.example.demo.trySpring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello2Controller {

    @GetMapping("/hello2")
    public String getHello2() {
        return "hello2/hello2"; // templates2階層目のファイルを指定
    }
}
