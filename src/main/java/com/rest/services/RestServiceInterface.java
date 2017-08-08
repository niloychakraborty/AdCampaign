package com.rest.services;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public interface RestServiceInterface {
	public ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
	public MongoOperations operations = (MongoOperations) ctx.getBean(MongoOperations.class);

}
