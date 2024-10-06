package com.example.bank_acc_service.service;

import com.example.bank_acc_service.entities.dto.AccountRequestDTO;
import com.example.bank_acc_service.entities.dto.AccountResponseDTO;
import org.springframework.stereotype.Service;


public interface AccountService {
    public AccountResponseDTO createAccount(AccountRequestDTO accountDTO);
    public AccountResponseDTO updateAccount(String id,AccountRequestDTO accountDTO);

}
