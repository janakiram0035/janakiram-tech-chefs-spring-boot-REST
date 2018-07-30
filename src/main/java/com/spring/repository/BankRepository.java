package com.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.entity.Bank;

public interface BankRepository  extends JpaRepository<Bank, Integer>{

	 @Query(value = "Select bank From bank b where b.bankName=:bankName")
	 Bank getBankByName(@Param("bankName") String bankName);
}
