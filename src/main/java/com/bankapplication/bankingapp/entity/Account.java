package com.bankapplication.bankingapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Account {

	@Id
	@SequenceGenerator(name = "account_sequence",
	sequenceName = "account-sequence",
	allocationSize = 1
			
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator ="account-sequence")
	private Integer id;
	private String AccountHolderName;
	private double balance;
	public Account(Integer id, String accountHolderName, double balance) {
		
		this.id = id;
		AccountHolderName = accountHolderName;
		this.balance = balance;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccountHolderName() {
		return AccountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		AccountHolderName = accountHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account() {
		
	}
	
}
