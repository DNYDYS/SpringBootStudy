package com.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.File;
import java.util.Date;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "邮件接口",tags = "邮件接口",description = "邮件接口")
@RequestMapping("/mail")
public class SendMailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("/sendMail")
    @ApiOperation(value = "简单邮件发送",notes = "简单邮件发送",produces = "application/json")
    public void sendMail(){
        //构建一个邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        //设置邮件主题
        message.setSubject("这是一封测试邮件");
        //设置邮件发送者
        message.setFrom("1786087581@qq.com");
        //设置邮件接收者，可以有多个接收者
        message.setTo("1051728040@qq.com","13014624617@163.com");
        //设置邮件抄送人，可以有多个抄送人
        message.setCc("1666310448@qq.com");
        //设置隐秘抄送人，可以有多个
        message.setBcc("lee9723@163.com");
        //设置邮件发送日期
        message.setSentDate(new Date());
        //设置邮件的正文
        message.setText("测试邮件正文");
        //发送邮件
        javaMailSender.send(message);
    }

    @GetMapping("/sendMailWithImg")
    @ApiOperation(value = "简单带图片邮件发送",notes = "简单带图片邮件发送",produces = "application/json")
    public void sendMailWithImg() throws MessagingException {
        //创建一个复杂的邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //设置邮件主题
        helper.setSubject("这是一封带图片测试邮件");
        //设置邮件发送者
        helper.setFrom("1786087581@qq.com");
        //设置邮件接收者
        helper.setTo("1051728040@qq.com");
        //设置邮件抄送人
        helper.setCc("1666310448@qq.com");
        //设置隐秘抄送人
        helper.setBcc("lee9723@163.com");
        //设置邮件发送日期
        helper.setSentDate(new Date());
        //设置邮件的正文
        helper.setText("<p>这是一封带图片测试邮件，这封邮件包含两种图片，分别如下</p><p>第一张图片：</p><img src='cid:p01'/><p>第二张图片：</p><img src='cid:p02'/>",true);
        helper.addInline("p01",new FileSystemResource(new File("C:\\Users\\hasee\\Desktop\\9cae14e699762b40a747d47cacf23198.jpg")));
        helper.addInline("p02",new FileSystemResource(new File("C:\\Users\\hasee\\Desktop\\微信图片_20210702155401.jpg")));
        javaMailSender.send(mimeMessage);
    }


}
