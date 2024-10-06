package com.example.bank_acc_service;

import com.example.bank_acc_service.entities.AccountType;
import com.example.bank_acc_service.entities.BankAccount;
import com.example.bank_acc_service.entities.Customer;
import com.example.bank_acc_service.repositories.BankAccountRepo;
import com.example.bank_acc_service.repositories.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepo bankAccountRepo, CustomerRepo customerRepo) {
		{

			return args -> {
				Stream.of("Mohamed", "Yassin", "Karim", "Ibrahim").forEach(c -> {
					Customer customer = Customer.builder().
							name(c)
							.build();

					customerRepo.save(customer);

				});
				customerRepo.findAll().forEach((customer -> {
					for (int i = 0; i < 10; i++) {
						BankAccount bankAccount = BankAccount.builder()
								.id(UUID.randomUUID().toString())
								.createdAt(new Date())
								.balance(7000 + Math.random() * 9000)
								.currency("USD")
								.type(Math.random() > 0.5 ? AccountType.SAVINGS : AccountType.CURRENT)
								.customer(customer)
								.build();

						bankAccountRepo.save(bankAccount);
					}

				}));



			};
		}

	}
}
