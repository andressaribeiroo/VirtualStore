package com.tech.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Date;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String remetente;
    public String envairEmailTexto(String destinatario, String titulo, String mensagem){

       try{
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(remetente);
        simpleMailMessage.setTo(destinatario);
        simpleMailMessage.setSubject(titulo);
        simpleMailMessage.setText(mensagem);
        javaMailSender.send(simpleMailMessage);
        return "Email enviado";

       } catch (Exception exception){
           return "Erro ao enviar o email";
       }
    }

}