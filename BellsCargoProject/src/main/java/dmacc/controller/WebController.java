package dmacc.controller;

import dmacc.beans.Account;
import dmacc.beans.Transaction;
import dmacc.repositories.AccountsRepository;
import dmacc.repositories.TransactionRepository;

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
		model.addAttribute("newAcc", acc);
		
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
		//add new Transaction object to the model
			//var transaction = new Transaction();
		//make sure to make transactionType set to whatever value withdraw will be and also set accountId
			//transaction.transactionType =
			//transaction.accountId =
			//transaction.transactionDate =
		//Add to modal all possible account that user can affect
			//model.addAttribute("accounts", 
			//model.addAttribute("transaction", transaction);
		Transaction trans = new Transaction();
		model.addAttribute("newWithdraw", trans);
		return "formTransaction";
	}
	
	@PostMapping("/withdraw")
	public String WithdrawForm(@ModelAttribute Transaction trans, Model model) {
		//add new Transaction object to the model
			//var transaction = new Transaction();
		//make sure to make transactionType set to whatever value withdraw will be and also set accountId
			//transaction.transactionType =
			//transaction.accountId =
			//transaction.transactionDate =
		//Add to modal all possible account that user can affect
			//model.addAttribute("accounts", 
			//model.addAttribute("transaction", transaction);
		transactionRepo.save(trans);
		return Accounts(model);
	}
	
	@GetMapping("/deposit")
	public String DepositForm(Model model) {
		//same as WithdrawForm()
		model.addAttribute("title", "Deposit");
		return "formTransaction";
	}
	
	@PostMapping("/addTransaction")
	public String AddTransaction(Transaction tran, Errors errors, Model model) {
		if(null != errors && errors.getErrorCount() > 0) return "formTransaction";
		
		transactionRepo.save(tran);
		
		return Index(model);
	}
	@PostMapping("/addAccount")
	public String AddAccount(Account acc, Errors errors, Model model) {
 		if(null != errors && errors.getErrorCount() > 0) return "formTransaction";

		accountRepo.save(acc);
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
}