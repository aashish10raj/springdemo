package com.helloworld.helloworld.greeting;

public class Greeting {

	private final long id;
	private final String name;
	
	public Greeting(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
}
