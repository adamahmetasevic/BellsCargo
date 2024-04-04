package dmacc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Halmar Arteaga - harteagabran
 * CIS175 - Spring 2024
 * Apr 3, 2024
 */
@Controller
public class WebController {
	//imports and repositories
	
	@GetMapping({"/", "/home"})
	public String Index(Model model) {
		return "index.html";
	}
	
	@GetMapping("/viewAccounts")
	public String Accounts(Model model) {
		//add list of accounts into the model
			//var accounts =
			//model.addAttribute("accounts", accounts);
		return "account";
	}
	
	@GetMapping("/addAcc")
	public String AccountForm(Model model) {
		//model.addAttribute("account", NEW ACCOUNT HERE);
		return "formAccount";
	}
	
	@GetMapping("/viewTransactions")
	public String Transactions(Model model) {
		//add list of deposits/withdrawals into a list for model
			//var transactions =
			//model.addAttribute("transactions", transactions);
		return "transaction";
	}
	
	@GetMapping("/withdraw")
	public String WithdrawForm(Model model) {
		//add new Transaction object to the model
			//var transaction = new Transaction();
		//make sure to make transactionType set to whatever value withdraw will be and also set accountId
			//transaction.transactionType =
			//transaction.accountId =
			//transaction.transactionDate =
		//Add to modal all possible account that user can affect
			//model.addAttribute("accounts", 
			//model.addAttribute("transaction", transaction);
		model.addAttribute("title", "Withdrawal");
		return "formTransaction";
	}
	@GetMapping("/deposit")
	public String DepositForm(Model model) {
		//same as WithdrawForm()
		model.addAttribute("title", "Deposit");
		return "formTransaction";
	}
	
	@PostMapping("/addTransaction")
	public String AddTransaction(@Valid Transaction tran, Errors errors, Model model) {
		if(null != errors && errors.getErrorCount() > 0) return "formTransaction";
		
		//save to repository
		
		return Index(model);
	}
	@PostMapping("/addAccount")
	public String AddAccount(@Valid Account acc, Errors errors, Model model) {
if(null != errors && errors.getErrorCount() > 0) return "formTransaction";
		
		//save to repository
		
		return Index(model);
	}
	
	/*
	 @GetMapping("/editAccount")
	 @GetMapping("/deleteAccount")
	 @GetMapping("/login")
	 @PostMapping("/login")
	 @GetMapping("/register")
	 @PostMapping("/register")
	*/
	 */
}