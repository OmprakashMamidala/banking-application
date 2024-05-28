package com.bankapplication.bankingapp.contollers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapplication.bankingapp.dto.AccountDto;
import com.bankapplication.bankingapp.service.AccountService;

@RestController
@RequestMapping("/api/accounts")

public class BankController {
	@Autowired
	private AccountService accountService;

	@PostMapping
	public AccountDto saveAccount(@RequestBody AccountDto accountDto) {
		return accountService.addAccount(accountDto);
	}

	@GetMapping("/{account_id}")
	public AccountDto getAccountById(@PathVariable("account_id") Integer id) {
		
		return accountService.getAccountById(id);
	}

	@PutMapping("/{account_id}/deposit")
	public AccountDto deposit(@PathVariable("account_id") Integer id, Map<String,Double>map) {
		return accountService.deposit(id, map.get("amount"));
	}

	@PutMapping("/{account_id}/withdraw")
	public AccountDto withDrawBalance(@PathVariable("account_id") Integer id, @RequestBody Map<String,Double>map) {
		return accountService.withDraw(id, map.get("amount"));
	}

	@GetMapping
	public List<AccountDto> getAllAccounts() {
		return accountService.allAccounts();
	}

	@DeleteMapping("{account_id}")
	public String removeAccount(@PathVariable("account_id") Integer id) {
		accountService.removeAccount(id);
		return "account with the id:" + id + " " + "is removed";
	}

}
