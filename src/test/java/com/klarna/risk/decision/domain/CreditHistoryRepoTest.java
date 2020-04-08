package com.klarna.risk.decision.domain;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class CreditHistoryRepoTest {

    private CreditHistoryRepository creditHistoryRepository;

    @Before
    public void before() {
        creditHistoryRepository = new CreditHistoryRepositoryImpl();
    }

    @After
    public void after() {
        creditHistoryRepository = null;
    }

    @Test
    public void shouldReturnEmptyListIfNoCustomerExist() {
        Collection<CustomerTransaction> list = creditHistoryRepository.lookupTransactions("anycostimer#gmail.com");
        Assert.assertThat(list.size(), Is.is(0));
    }

    @Test
    public void shouldReturnTransactionIfExist() {
        CustomerTransaction customerTransaction = new CustomerTransaction("debt", 100);
        creditHistoryRepository.addTransaction("john@gmail.com", customerTransaction);

        Collection<CustomerTransaction> list = creditHistoryRepository.lookupTransactions("john@gmail.com");
        Assert.assertThat(list.size(), Is.is(1));
    }

    @Test
    public void shouldReturnTransactionForReasonIfExist() {
        CustomerTransaction customerTransaction = new CustomerTransaction("debt", 100);
        creditHistoryRepository.addTransaction("john@gmail.com", customerTransaction);

        Collection<CustomerTransaction> list = creditHistoryRepository.lookupTransactions("john@gmail.com", "debt");
        Assert.assertThat(list.size(), Is.is(1));
    }

}
