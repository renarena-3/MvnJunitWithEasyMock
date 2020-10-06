package com.pratham.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pratham.service.ContactService;

@Component
public class MyRunner implements CommandLineRunner {

	private ContactService service;
	
	
	public MyRunner(ContactService service) {
		super();
		this.service = service;
	}


	@Override
	public void run(String... args) throws Exception {
		
	String name = service.getNameById(101);
		System.out.println("name "+name);

	}

}
