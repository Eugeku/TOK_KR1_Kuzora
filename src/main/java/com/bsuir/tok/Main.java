package com.bsuir.tok;

import com.bsuir.tok.command.exception.CommandException;
import com.bsuir.tok.controller.Controller;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws CommandException {
        System.out.println(args[0]);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println(context.getBean(Controller.class).executeRequest(args[0]));
        System.out.println(args[0]);
    }
}
