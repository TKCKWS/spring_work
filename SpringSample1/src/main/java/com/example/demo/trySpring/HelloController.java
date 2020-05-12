package com.example.demo.trySpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // SpringではControllerクラスに @Controllerアノテーションを付ける
public class HelloController {

    @GetMapping("/hello") // Getメソッドで送られてきた場合の処理
    public String getHello() {
        return "hello"; // HTMLファイル名を指定。resurces/templates/hello.htmlを表示、という意味
    }

    @PostMapping("/hello") // Postメソッドで送られてきた場合の処理
    public String postRequest(@RequestParam("text1") String text1, Model model) {
        // @RequestParamアノテーションをつけることで、画面からの入力内容を受け取ることが出来る
        // アノテーションの引数にはhtmlのname属性の値を指定する

        // 画面から受け取った文字列をmodelに登録
        model.addAttribute("text1", text1); // キーと値をセット

        // helloResponse.htmlを表示
        return "helloResponse";
    }
}
