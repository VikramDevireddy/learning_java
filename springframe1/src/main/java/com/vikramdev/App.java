package com.vikramdev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Appcontext.xml");

        System.out.println("Hello World!");

        Alien obj = (Alien) context.getBean("alien");
        // Alien obj2 = (Alien) context.getBean("alien");
        obj.hello();
        // obj2.hello();

        // System.out.println("o1=" + obj.age);
        // System.out.println(" o2=" + obj2.age);
    }
}
