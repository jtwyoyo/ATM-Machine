/* Copyright (C) 2023 <Full Name (can be multiple persons) - All Rights Reserved
* You may use, distribute and modify this code under the terms of the XYZ license. */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private Account account;
    private Double amount = 100.0;

    @BeforeEach
    public void setUp() {
        account = new Account(12345, 6789, 1000.0, 2000.0);
    }

    @Test
    public void testGetCheckingBalance() {
        assertEquals(1000.0, account.getCheckingBalance(), 0.001);
    }

    @Test
    public void testGetSavingBalance() {
        assertEquals(2000.0, account.getSavingBalance(), 0.001);
    }

    @Test
    public void testCheckNotNull(){
        assertNotEquals(null, amount);
        assertNotEquals(null, account.getCheckingBalance());
        assertNotEquals(null, account.getSavingBalance());
    }
    @Test
    public void testcalcCheckTransfer(){
        account.calcCheckTransfer(amount);
        assertEquals(900.0,account.getCheckingBalance());
        assertEquals(2100.0,account.getSavingBalance());
    }

    @Test
    public void testcalcSavingTransfer(){
        account.calcSavingTransfer(amount);
        assertEquals(1100.0,account.getCheckingBalance());
        assertEquals(1900.0,account.getSavingBalance());
    }
}
