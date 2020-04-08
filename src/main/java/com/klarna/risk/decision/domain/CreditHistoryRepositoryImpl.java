package com.klarna.risk.decision.domain;

import com.google.common.collect.Maps;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The implementation of the {@link CreditHistoryRepository} interface.
 */
public class CreditHistoryRepositoryImpl implements CreditHistoryRepository {

    private Map<String, List<CustomerTransaction>> customerTransactionStorage = Maps.newConcurrentMap();

    @Override
    public Collection lookupTransactions(String email) {
        return customerTransactionStorage.getOrDefault(email, Collections.emptyList());
    }

    @Override
    public void addTransaction(String email, CustomerTransaction customerTransaction) {
        argumentCheck(email, customerTransaction);
        List<CustomerTransaction> customerTransactions = customerTransactionStorage.getOrDefault(email, new ArrayList<>());
        customerTransactions.add(customerTransaction);
        customerTransactionStorage.put(email, customerTransactions);
    }

    @Override
    public Collection lookupTransactions(String email, String reason) {
        return customerTransactionStorage.getOrDefault(email, Collections.emptyList()).stream()
                .filter(transaction -> transaction.getReason().equals(reason))
                .collect(Collectors.toList());
    }

    private void argumentCheck(String email, CustomerTransaction customerTransaction) {
        if (email == null || "".equals(email.trim())) {
            throw new IllegalArgumentException();
        }

        if (customerTransaction == null) {
            throw new IllegalArgumentException();
        }
    }
}
