package com.example.demo.login.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    // 全てのコントローラクラスのメソッドが対象
    @Before("execution( * *..*.*Controller.*(..))")
    public void startLog(JoinPoint jp) {
        System.out.println("メソッド開始 : " + jp.getSignature());
    }

    // 全てのコントローラクラスのメソッドが対象
    @After("execution( * *..*.*Controller.* (..))")
    public void endLog(JoinPoint jp) {
        System.out.println("メソッド終了 : " + jp.getSignature());
    }
}
