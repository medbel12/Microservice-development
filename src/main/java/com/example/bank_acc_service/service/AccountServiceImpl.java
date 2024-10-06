package com.example.bank_acc_service.service;

import com.example.bank_acc_service.entities.BankAccount;
import com.example.bank_acc_service.entities.dto.AccountRequestDTO;
import com.example.bank_acc_service.entities.dto.AccountResponseDTO;
import com.example.bank_acc_service.mappers.AccountMapper;
import com.example.bank_acc_service.repositories.BankAccountRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;


@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    private BankAccountRepo bankAccountRepo;
    private AccountMapper accountMapper;

    public AccountServiceImpl(BankAccountRepo bankAccountRepo , AccountMapper accountMapper) {
        this.bankAccountRepo = bankAccountRepo;
        this.accountMapper = accountMapper;
    }
    @Override
    public AccountResponseDTO createAccount(AccountRequestDTO accountDTO) {
        BankAccount account = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(accountDTO.getBalance())
                .currency(accountDTO.getCurrency())
                .type(accountDTO.getType())
                .build();

        BankAccount savedbankAccount = bankAccountRepo.save(account);

        AccountResponseDTO accountResponseDTO=accountMapper.fromAccount(savedbankAccount);
        return accountResponseDTO;

    }

    @Override
    public AccountResponseDTO updateAccount(String id,AccountRequestDTO accountDTO) {

        BankAccount account = BankAccount.builder()
                .id(id)
                .createdAt(new Date())
                .balance(accountDTO.getBalance())
                .currency(accountDTO.getCurrency())
                .type(accountDTO.getType())
                .build();

        BankAccount savedbankAccount = bankAccountRepo.save(account);

        AccountResponseDTO accountResponseDTO=accountMapper.fromAccount(savedbankAccount);
        return accountResponseDTO;

    }


}
