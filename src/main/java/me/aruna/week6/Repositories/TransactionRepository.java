package me.aruna.week6.Repositories;

import me.aruna.week6.Entities.BankUserData;

import org.springframework.data.repository.CrudRepository;


public interface TransactionRepository extends CrudRepository<BankUserData,Long> {
    BankUserData findByAccount(String account);
    BankUserData findByDate(String date);
    Long countByEmail(String email);
    Long countByUsername(String username);




}

