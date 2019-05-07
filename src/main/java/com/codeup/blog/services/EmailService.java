package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    public JavaMailSender emailSender;

    @Value("${spring.mail.from}")
    private String from;

   public void prepareAndSend (Post post) {
       SimpleMailMessage msg = new SimpleMailMessage();
       msg.setFrom(from);
       msg.setSubject(post.getTitle());
       msg.setText(post.getBody());

       this.emailSender.send(msg);
   }
}