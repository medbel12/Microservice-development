package com.example.bank_acc_service.entities.dto;

import com.example.bank_acc_service.entities.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class AccountRequestDTO {
    private Double balance;
    private  String currency;
    private AccountType type;
}
