package com.maharjan.amit.testingExceptions;

import org.junit.Assert;
import org.junit.Test;

public class CashierTest {
    @Test
    public void validateTransactionThrowsIllegalArgumentException() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            Cashier.validateTransaction("USD", 100);
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateTransactionThrowsIllegalArgumentException2() {
        Cashier.validateTransaction("USD", 100);
    }

    @Test(expected = InvalidTransactionAmountException.class)
    public void validateTransactionThrowsInvalidTransactionAmountException() {
        Cashier.validateTransaction("EUR", -100);
    }
}
