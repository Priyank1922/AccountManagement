package com.example.AccountManagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AccountManagement.dto.Transfer;
import com.example.AccountManagement.entity.Accounts;
import com.example.AccountManagement.service.AccountService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/account")
@AllArgsConstructor

public class AccountController {

	public AccountService service;

	@GetMapping
	public List<Accounts> getAll() {
		return service.GetAll();
	}

	@GetMapping("/{id}")
	public Accounts getOne(@RequestBody Long id) {
		return service.GetOne(id);
	}

	@PostMapping
	public Accounts saveNewAccount(@RequestBody Accounts acc) {
		return service.create(acc);
	}

	@PostMapping("/transfer")
	public String transfer(@RequestBody Transfer t) {
		return service.transfer(t);
	}
}
