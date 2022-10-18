package com.example.demo;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Subtraction implements Operations {

	@Override
	public int[] operate(int[] val) {
		// TODO Auto-generated method stub
		int m= val[0];
		int n=val[1];
		int res= m-n;
		System.out.println(res);
		return null;
		
	}

}
