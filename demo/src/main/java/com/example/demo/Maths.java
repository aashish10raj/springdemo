package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Maths {
	@Autowired
	private Operations operate;
	
	public int[] getdata(int[] data) {
		
		int[] val= new int[2];
		val[0]=data[0];
		val[1]=data[1];
		operate.operate(val);
		return null;
		 
	}

	

}
