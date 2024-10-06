package com.example.bank_acc_service.repositories;

import com.example.bank_acc_service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
