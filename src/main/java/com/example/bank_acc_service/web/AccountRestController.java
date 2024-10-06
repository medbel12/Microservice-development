package com.example.bank_acc_service.web;

import com.example.bank_acc_service.entities.BankAccount;
import com.example.bank_acc_service.entities.dto.AccountRequestDTO;
import com.example.bank_acc_service.entities.dto.AccountResponseDTO;
import com.example.bank_acc_service.mappers.AccountMapper;
import com.example.bank_acc_service.repositories.BankAccountRepo;
import com.example.bank_acc_service.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepo bankAccountRepo;
    private AccountService accountService;
    private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepo bankAccountRepo, AccountService accountService, AccountMapper accountMapper) {
        this.bankAccountRepo = bankAccountRepo;
        this.accountService = accountService;
        this.accountMapper = accountMapper;

    }



    @GetMapping("/accounts")
    public List<BankAccount> getAccounts() {
        return bankAccountRepo.findAll();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount getAccount(@PathVariable String id) {
        return bankAccountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @PostMapping("/accounts")
    public AccountResponseDTO save(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.createAccount(accountRequestDTO);
    }

    @PutMapping("/accounts/{id}")
    public  BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        BankAccount account = bankAccountRepo.findById(id).orElseThrow();
        if (bankAccount.getBalance()!=null) bankAccount.setBalance(bankAccount.getBalance());
        if (bankAccount.getCurrency()!=null) bankAccount.setCurrency(bankAccount.getCurrency());
        if (bankAccount.getType()!=null) bankAccount.setType(bankAccount.getType());
        if (bankAccount.getCreatedAt()!=null) bankAccount.setCreatedAt(bankAccount.getCreatedAt());
        return bankAccountRepo.save(account);
    }

    @DeleteMapping("/accounts/{id}")
    public void delete(@PathVariable String id){
        bankAccountRepo.deleteById(id);
    }
}