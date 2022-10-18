package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		Scanner sc = new Scanner(System.in);
		System.out.println("first number");
		int[] data = new int[2];
		data[0] = sc.nextInt();
		System.out.println("second number");
		 data[1]=sc.nextInt();
		Maths maths = context.getBean(Maths.class);
		maths.getdata(data);
		
	}

}
