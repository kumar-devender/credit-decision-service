package com.klarna.risk.decision.domain;

/**
 * A class representing customer debt which is the sum of all of the purchases done by the customer.
 */
public class CustomerTransaction {

    /**
     * The primary identifier of the customer.
     */
    private String reason;

    /**
     * The sum of the customer's all approved puchases.
     */
    private int amount;

    public CustomerTransaction() {
        // default
    }

    public CustomerTransaction(String reason, int amount) {
        this.reason = reason;
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
