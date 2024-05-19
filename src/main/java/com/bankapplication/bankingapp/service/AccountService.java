package com.bankapplication.bankingapp.service;

import java.util.List;

import com.bankapplication.bankingapp.dto.AccountDto;

public interface AccountService {
 AccountDto addAccount(AccountDto account);
  
AccountDto getAccountById(Integer id);
AccountDto deposit(Integer id,double balance);
AccountDto withDraw(Integer id,double balance);
List<AccountDto> allAccounts();
void removeAccount(Integer id);
}
