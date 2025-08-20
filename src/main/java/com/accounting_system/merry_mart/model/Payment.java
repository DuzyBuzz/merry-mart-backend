package com.accounting_system.merry_mart.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "payment_id", updatable = false, nullable = false)
    @JsonProperty("paymentId")
    private UUID paymentId;

    private String status;
    private int invoiceNo;

    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    private String bankName;
    private String checkNo;

    @Temporal(TemporalType.DATE)
    private Date clearingDate;

    private String userID;

    public Payment() {
    }

    public Payment(@JsonProperty("status") String status,
                   @JsonProperty("invoiceNo") int invoiceNo,
                   @JsonProperty("paymentDate") Date paymentDate,
                   @JsonProperty("bankName") String bankName,
                   @JsonProperty("checkNo") String checkNo,
                   @JsonProperty("clearingDate") Date clearingDate,
                   @JsonProperty("userID") String userID) {
        this.status = status;
        this.invoiceNo = invoiceNo;
        this.paymentDate = paymentDate;
        this.bankName = bankName;
        this.checkNo = checkNo;
        this.clearingDate = clearingDate;
        this.userID = userID;
    }


    public UUID getPaymentId() {
        return paymentId;
    }

    public String getStatus() {
        return status;
    }

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public String getBankName() {
        return bankName;
    }

    public String getCheckNo() {
        return checkNo;
    }

    public Date getClearingDate() {
        return clearingDate;
    }

    public String getUserID() {
        return userID;
    }



    public void setStatus(String status) {
        this.status = status;
    }

    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo;
    }

    public void setClearingDate(Date clearingDate) {
        this.clearingDate = clearingDate;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
