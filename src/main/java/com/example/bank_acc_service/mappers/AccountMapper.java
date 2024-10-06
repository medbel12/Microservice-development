package com.example.bank_acc_service.mappers;

import com.example.bank_acc_service.entities.BankAccount;
import com.example.bank_acc_service.entities.dto.AccountResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public static AccountResponseDTO fromAccount(BankAccount account) {
    AccountResponseDTO accountResponseDTO=new AccountResponseDTO();
        BeanUtils.copyProperties(account, accountResponseDTO);
        return accountResponseDTO;

}
}
