package com.example.demo.trySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // SpringではControllerクラスに @Controllerアノテーションを付ける
public class HelloController {

    @Autowired HelloService helloService;

    /**
     * GET処理(/hello)
     * @return
     */
    @GetMapping("/hello") // Getメソッドで送られてきた場合の処理
    public String getHello() {
        return "hello"; // HTMLファイル名を指定。resurces/templates/hello.htmlを表示、という意味
    }

    /**
     * POST処理(/hello)
     * @param text1 POSTされたtext1文字列
     * @param model モデル
     * @return template(helloResponse.html)
     */
    @PostMapping("/hello") // Postメソッドで送られてきた場合の処理
    public String postRequest(@RequestParam("text1") String text1, Model model) {
        // @RequestParamアノテーションをつけることで、画面からの入力内容を受け取ることが出来る
        // アノテーションの引数にはhtmlのname属性の値を指定する

        // 画面から受け取った文字列をmodelに登録
        model.addAttribute("text1", text1); // キーと値をセット

        // helloResponse.htmlを表示
        return "helloResponse";
    }

    /**
     * POST処理(/hello/db)
     * @param text2 ID
     * @param model モデル
     * @return template(helloResponseDB.html)
     */
    @PostMapping("/hello/db")
    public String postDbRequest(@RequestParam("text2") String text2, Model model) {

        // Stringからint型に変換
        int id = Integer.parseInt(text2);

        // 1件検索
        Employee employee = helloService.findOne(id);

        // 検索結果をModelに登録
        model.addAttribute("id", employee.getEmployeeId());
        model.addAttribute("name", employee.getEmployeeName());
        model.addAttribute("age", employee.getAge());

        // helloResponseDB.htmlを表示
        return "helloResponseDB";
    }
}
