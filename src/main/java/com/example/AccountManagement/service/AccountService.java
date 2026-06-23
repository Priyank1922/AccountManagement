package com.example.AccountManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.AccountManagement.dto.Transfer;
import com.example.AccountManagement.entity.Accounts;
import com.example.AccountManagement.repository.AccountsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountService {

	private AccountsRepository repo;

	public Accounts create(Accounts ac) {
		return repo.save(ac);
	}

	public Accounts WithDrawl(Long id, Double amount) {
		Accounts ac = repo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
		ac.setBalance(ac.getBalance() - amount);

		return repo.save(ac);
	}

	public Accounts deposit(Long id, Double amount) {
		Accounts ac = repo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
		ac.setBalance(ac.getBalance() + amount);

		return repo.save(ac);
	}

	public List<Accounts> GetAll() {
		return repo.findAll();
	}

	public Accounts GetOne(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
	}

	@Transactional
	public String transfer(Transfer t) {
		Accounts from = repo.findById(t.from()).orElseThrow(() -> new RuntimeException("Not found"));
		Accounts to = repo.findById(t.from()).orElseThrow(() -> new RuntimeException("Not found"));

		if (from.getBalance() > t.amount()) {
			from.setBalance(from.getBalance() - t.amount());
			to.setBalance(to.getBalance() + t.amount());

			repo.save(from);
			repo.save(to);
		} else {
			throw new RuntimeException("Insufuccient balance!!");
		}

		return "Transfer successfully";
	}
}
