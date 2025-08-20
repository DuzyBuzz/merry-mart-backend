package com.accounting_system.merry_mart.repository;

import com.accounting_system.merry_mart.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepo extends JpaRepository<Payment, UUID> {
}
