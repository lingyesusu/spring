package service.impl;

import org.springframework.stereotype.Component;

import service.Service;

@Component
public class ServiceImpl implements Service {

	@Override
	public String say() {
		System.out.println("service÷¥––");
		return "hello";
	}

}
