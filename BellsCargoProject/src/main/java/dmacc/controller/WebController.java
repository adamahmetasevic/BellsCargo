package dmacc.controller;

import dmacc.beans.Account;
import dmacc.beans.Transaction;
import dmacc.repositories.AccountsRepository;
import dmacc.repositories.TransactionRepository;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Halmar Arteaga - harteagabran
 * CIS175 - Spring 2024
 * Apr 3, 2024
 */
@Controller
public class WebController {
	//imports and repositories
	@Autowired 
	private AccountsRepository accountRepo;
	@Autowired
	private TransactionRepository transactionRepo;
	
	@GetMapping({"/", "/home"})
	public String Index(Model model) {
		return "index.html";
	}
	
	@GetMapping("/viewAccounts")
	public String Accounts(Model model) {
//		if(accountRepo.findAll().isEmpty()) {
//			return AccountForm(model);
//		}
		
		model.addAttribute("todos", accountRepo.findAll());
		
		return "account";
	}
	
	@GetMapping("/addAcc")
	public String AccountForm(Model model) {
		Account acc = new Account();
		model.addAttribute("account", acc);
		
		return "formAccount";
	}
	
	@GetMapping("/viewTransactions")
	public String Transactions(Model model) {
//		if(accountRepo.findAll().isEmpty()) {
//			return Index(model);
//		}
		
		model.addAttribute("transactons", transactionRepo.findAll());
		return "transaction";
	}
	
	@GetMapping("/withdraw")
	public String WithdrawForm(Model model) {
		Transaction trans = new Transaction();
		trans.setTransactionType("withdraw");
		model.addAttribute("title", "Deposit");
		model.addAttribute("transaction", trans);
		//model.addAttribute("accounts",
		return "formTransaction";
	}
	
	@GetMapping("/deposit")
	public String DepositForm(Model model) {
		//same as WithdrawForm()
		Transaction trans = new Transaction();
		trans.setTransactionType("deposit");
		model.addAttribute("title", "Deposit");
		model.addAttribute("transaction", trans);
		return "formTransaction";
	}
	
	@PostMapping("/addTransaction")
	public String AddTransaction(Transaction tran, Errors errors, Model model) {
		//if(null != errors && errors.getErrorCount() > 0) return "formTransaction";
		Date currentDateTime = new Date();
		tran.setTransactionDate(currentDateTime);
		transactionRepo.save(tran);
		
		return Index(model);
	}
	@PostMapping("/addAccount")
	public String AddAccount(Account acc, Errors errors, Model model) {
 		//if(null != errors && errors.getErrorCount() > 0) return "formAccount";
		Date currentDateTime = new Date();
		acc.setAccountDate(currentDateTime);
		accountRepo.save(acc);
		return "index.html";
	}
	
	/*
	 @GetMapping("/editAccount")
	 @GetMapping("/deleteAccount")
	 @GetMapping("/login")
	 @PostMapping("/login")
	 @GetMapping("/register")
	 @PostMapping("/register")
	*/
}