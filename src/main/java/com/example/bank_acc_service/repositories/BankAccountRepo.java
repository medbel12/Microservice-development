package com.example.bank_acc_service.repositories;

import com.example.bank_acc_service.entities.AccountType;
import com.example.bank_acc_service.entities.BankAccount;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepo extends JpaRepository<BankAccount, String> {
    @RestResource(path = "/byType")
    List<BankAccount> findByType( @PathParam("t") AccountType type);
}
