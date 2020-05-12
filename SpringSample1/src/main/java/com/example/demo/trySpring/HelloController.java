package com.example.demo.trySpring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // SpringではControllerクラスに @Controllerアノテーションを付ける
public class HelloController {

    @GetMapping("/hello") // Getメソッドを処理できる
    public String getHello() {
        return "hello"; // HTMLファイル名を指定。resurces/templates/hello.htmlを表示、という意味
    }
}
