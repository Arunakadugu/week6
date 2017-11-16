package me.aruna.week6.Repositories;

import me.aruna.week6.Entities.UserRole;
import org.springframework.data.repository.CrudRepository;
import java.util.Set;

 public interface RoleRepository extends CrudRepository<UserRole,Long> {
        UserRole findByRole(String role);




    }

