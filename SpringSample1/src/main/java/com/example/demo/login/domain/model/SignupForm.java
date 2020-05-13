package com.example.demo.login.domain.model;

import java.util.Date;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {

    // 必須入力、メールアドレス形式
    @NotBlank(message = "{require_check}")
    @Email(message = "{email_check}")
    private String userId; // ユーザーID

    // 必須入力、
    @NotBlank(message = "{require_check}")
    @Length(min = 4, max = 100, message = "{length_check}")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "{pattern_check}")
    private String password; // パスワード

    // 必須入力
    @NotBlank(message = "{require_check}")
    private String userName; // ユーザー名

    // 必須入力
    @NotNull(message = "{require_check}")
    @DateTimeFormat(pattern = "yyyy/MM/dd") // DateTimeFormatアノテーションをフィールドにつけると文字列を日付型に変換
    private Date birthday; // 誕生日

    // 値が20から100まで
    @Min(value=20, message="{min_check}")
    @Max(value=100, message="{max_check}")
    private int age; // 年齢

    // falseのみ可能
    @AssertFalse(message = "{marriage_check}")
    private boolean marriage; // 結婚ステータス
}
