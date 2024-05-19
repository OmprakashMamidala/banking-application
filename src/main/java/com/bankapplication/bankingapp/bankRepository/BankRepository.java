package com.bankapplication.bankingapp.bankRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapplication.bankingapp.entity.Account;
@Repository
public interface BankRepository extends JpaRepository<Account, Integer> {

}
