/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lol.vendotron;

import com.lol.vendotron.controller.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Henry
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext
                = new AnnotationConfigApplicationContext();
        
        appContext.scan("com.lol.vendotron");
        appContext.refresh();
        
        VendotronController controller = appContext.getBean("vendotronController", VendotronController.class);

        controller.run();
    }

}
