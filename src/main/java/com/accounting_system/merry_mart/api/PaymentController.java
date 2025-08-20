package com.accounting_system.merry_mart.api;

import com.accounting_system.merry_mart.model.Payment;
import com.accounting_system.merry_mart.repository.PaymentRepo;
import com.accounting_system.merry_mart.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentRepo paymentRepo;

    public PaymentController(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    // ✅ Save a payment (POST)
    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentRepo.save(payment);
    }

    // ✅ Get all payments
    @GetMapping
    public List<Payment> getPayments() {
        return paymentRepo.findAll();
    }
}