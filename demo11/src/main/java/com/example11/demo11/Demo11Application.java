package com.example11.demo11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demo11Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Demo11Application.class, args);
		System.out.println("hii vikram fianlly in boot");
		Alien a = context.getBean(Alien.class);
		a.code();
	}

}
