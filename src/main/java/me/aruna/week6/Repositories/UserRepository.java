package me.aruna.week6.Repositories;

import me.aruna.week6.Entities.BankUserData;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<BankUserData,Long> {
    BankUserData findByUsername(String username);
    BankUserData findByEmail(String email);
    Long countByEmail(String email);
    Long countByUsername(String username);
}