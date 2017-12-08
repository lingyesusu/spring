package org.shiro.demo;

import java.util.EmptyStackException;

import org.apache.log4j.PropertyConfigurator;

public class LogMainUnit {
	
	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemResource("log4j.properties").getPath());
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		new EmptyStackException();
	}

}
