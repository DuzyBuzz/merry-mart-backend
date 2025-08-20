package com.accounting_system.merry_mart.service;


import com.accounting_system.merry_mart.model.Payment;
import com.accounting_system.merry_mart.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    public List<Payment> getAllPayments(){
        return paymentRepo.findAll();
    }

    public  Payment getPaymentId(UUID paymentId){
        return paymentRepo.findById(paymentId).orElse(null);
    }

    public Payment createPayment(Payment payment){
        return paymentRepo.save(payment);
    }


    public Payment updatePayment(UUID paymentId, Payment payment){
        return paymentRepo.findById(paymentId).map(existing ->{
            existing.setStatus(payment.getStatus());
            existing.setInvoiceNo(payment.getInvoiceNo());
            existing.setPaymentDate(payment.getPaymentDate());
            existing.setBankName(payment.getBankName());
            existing.setCheckNo(payment.getCheckNo());
            existing.setClearingDate(payment.getClearingDate());
            existing.setUserID(payment.getUserID());

            return paymentRepo.save(existing);
        }).orElse(null);
    }

    public void deletePayment(UUID paymentId){
        paymentRepo.deleteById(paymentId);
    }

}
