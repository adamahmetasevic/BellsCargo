package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Account;
import dmacc.beans.Transaction;
import dmacc.beans.User;

@Configuration
public class BeanConfiguration {
	@Bean
	public Account account() {
		Account bean = new Account();
		
		return bean;
	}
	
	@Bean
	public Transaction transaction() {
		Transaction bean = new Transaction();
		
		return bean;
	}
	
	@Bean
	public User user() {
		User bean = new User();
		
		return bean;
	}
}
