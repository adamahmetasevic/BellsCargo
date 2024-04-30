package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Account;
import dmacc.beans.Budget;
import dmacc.beans.BudgetItem;
import dmacc.beans.Transaction;
import dmacc.beans.UserEntity;

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
	public UserEntity user() {
		UserEntity bean = new UserEntity();
		
		return bean;
	}
	
	@Bean
	public Budget budget() {
		Budget bean = new Budget();
		
		return bean;
	}
	
	@Bean
	public BudgetItem budgetItem() {
		BudgetItem bean = new BudgetItem();
		
		return bean;
	}
}
