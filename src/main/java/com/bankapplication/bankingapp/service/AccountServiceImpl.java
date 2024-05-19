package com.bankapplication.bankingapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapplication.bankingapp.bankRepository.BankRepository;
import com.bankapplication.bankingapp.dto.AccountDto;
import com.bankapplication.bankingapp.entity.Account;
import com.bankapplication.bankingapp.mapper.AccountMapper;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private BankRepository bankRepository;

	@Override
	public AccountDto addAccount(AccountDto accountDto) {
		// TODO Auto-generated method stub
		Account account = AccountMapper.mapToAccount(accountDto);

		Account savedAccount = bankRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(Integer id) {
		// TODO Auto-generated method stub
		Account account = bankRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Integer id, double balance) {
		// TODO Auto-generated method stub
		Account account = bankRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
		account.setBalance(balance + account.getBalance());
		Account savedAccount = bankRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withDraw(Integer id, double balance) {
		// TODO Auto-generated method stub
		Account account = bankRepository.findById(id).orElseThrow(() -> new RuntimeException("error id not found"));
		if (account.getBalance() < balance) {
			throw new RuntimeException("insufficent balance");
		}
		account.setBalance(account.getBalance() - balance);
		Account savedAccount = bankRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public List<AccountDto> allAccounts() {
		// TODO Auto-generated method stub
		List<Account> accounts = bankRepository.findAll();
		return accounts.stream().map((account)->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
	}

	@Override
	public void removeAccount(Integer id) {
		bankRepository.findById(id).stream().map((account)->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
		bankRepository.deleteById(id);
		
	}

}
