package com.accounting_system.merry_mart.repository;

import com.accounting_system.merry_mart.model.Payment;
import com.accounting_system.merry_mart.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsersRepo  extends JpaRepository<Users, UUID> {
    Optional<Users> findByUserName(String userName);
}

