package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

/**
 * @Author sir
 * @Date 2020/1/6 9:36
 * @Description TODO
 **/
@RestController
@RequestMapping("/email")
public class DemoController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/send/{to}")
    public String sendEmail(@PathVariable String to) {
        new Thread(()->{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("243548880@qq.com"); // 邮件发送者
            message.setTo(to); // 邮件接受者
            message.setSubject("测试邮件"); // 主题
            message.setText("hello world !"); // 内容
            mailSender.send(message);
        }).start();
        return "发送成功";
    }
}
