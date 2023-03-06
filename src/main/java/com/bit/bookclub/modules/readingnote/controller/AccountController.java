//package com.bit.bookclub.modules.readingnote.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bit.bookclub.modules.readingnote.entity.Account;
//import com.bit.bookclub.modules.readingnote.repository.AccountRepository;
//import com.bit.bookclub.modules.readingnote.service.AccountService;
//
//@RestController
//@RequestMapping("/account")
//public class AccountController {
//
//	@Autowired
//	private AccountService accountService;
//	
//	@Autowired
//	private AccountRepository accountRepository;
//	
//	@GetMapping("/list")
//	public List<Account> getAll() {
//		
//		System.out.println("user_count=" + accountRepository.count());
//		System.out.println("male_count=" + accountRepository.countByGender("male"));
//		
//		return accountService.getAccountList();
//	}
//	
//	@GetMapping("/list/{id}")
//	public Optional<Account> getAccountById(@PathVariable("id") Integer id) {
//		
//		return accountService.getAccountListById(id);
//	}
//	
//	@PostMapping("/regist")
//	public Account registAccount(@RequestBody Account account) {
//		
//		return accountService.registAccount(account);
//	}
//	
//	@PutMapping("/update/{id}")
//	public void updateAccount(
//			@PathVariable("id") Integer id,
//			@RequestBody Account account) {
//		
//		accountService.updateAccount(account);
//	}
//	
//	@DeleteMapping("/delete/{id}")
//	public void removeAccount(@PathVariable Integer id) {
//		
//		accountService.removeAccount(id);
//	}
//	
////	@GetMapping("/test")
////	public void getAgeGraph(Account account) {
////		
////		accountService.ageGraph(null);
////	}
//	
//}
