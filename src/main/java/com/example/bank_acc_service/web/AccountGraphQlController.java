package com.example.bank_acc_service.web;

import com.example.bank_acc_service.entities.BankAccount;
import com.example.bank_acc_service.entities.Customer;
import com.example.bank_acc_service.entities.dto.AccountRequestDTO;
import com.example.bank_acc_service.entities.dto.AccountResponseDTO;
import com.example.bank_acc_service.repositories.BankAccountRepo;
import com.example.bank_acc_service.repositories.CustomerRepo;
import com.example.bank_acc_service.service.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountGraphQlController {

    private BankAccountRepo accountRepo;
    private AccountService accountService;
    private CustomerRepo customerRepo;

    public AccountGraphQlController(BankAccountRepo accountRepo, AccountService accountService,CustomerRepo customerRepo) {
        this.accountRepo = accountRepo;
        this.accountService = accountService;
        this.customerRepo = customerRepo;
    }

    @QueryMapping
    public List<BankAccount> accountList() {
        return accountRepo.findAll();
    }
    @QueryMapping
    public BankAccount accountById(@Argument String id) {
        return accountRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found",id)));
    }
    @MutationMapping
    public AccountResponseDTO createAccount(@Argument AccountRequestDTO account) {
        return accountService.createAccount(account);
    }
    @MutationMapping
    public AccountResponseDTO updateAccount(@Argument String id,@Argument AccountRequestDTO account) {
        return accountService.updateAccount(id,account);
    }
    @MutationMapping
    public void deleteAccount(@Argument String id) {
         accountRepo.deleteById(id);
    }
    @QueryMapping
    public List<Customer>customers(){
        return customerRepo.findAll();
    }



}
