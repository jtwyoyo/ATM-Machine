/* Copyright (C) 2023 <Apichaya Maneewong (can be multiple persons) - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the XYZ license. */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TransferTest {
    private Account account;
    private Double amount = 100.0;

    @BeforeEach
    public void setUp() {
        account = new Account(12345, 6789, 1000.0, 2000.0);
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
    @Test
    public void testcalcCheckingWithdraw(){
        // amount > 0, checkingBalance > 0, amount = checkingBalance
        test_1_account = new Account(12345, 6789, 100.0, 2000.0);
        testcheckingBalance = test_1_account.calcCheckingWithdraw(100.0);
        Assert.assertEquals(0, testcheckingBalance);

        // amount = 0, checkingBalance = 0, amount = checkingBalance
        test_2_account = new Account(12345, 6789, 0.0, 2000.0);
        testcheckingBalance = test_2_account.calcCheckingWithdraw(0.0);
        Assert.assertEquals(0, testcheckingBalance);

        // amount < 0, checkingBalance < 0, amount = checkingBalance
        test_3_account = new Account(12345, 6789, -100.0, 2000.0);
        testcheckingBalance = test_3_account.calcCheckingWithdraw(-100.0);
        Assert.assertEquals(0, testcheckingBalance);

        // amount > 0, checkingBalance = 0, amount > checkingBalance
        test_4_account = new Account(12345, 6789, 0.0, 2000.0);
        testcheckingBalance = test_4_account.calcCheckingWithdraw(100.0);
        Assert.assertEquals(-100.0, testcheckingBalance);

        // amount = 0, checkingBalance < 0, amount > checkingBalance
        test_5_account = new Account(12345, 6789, -100.0, 2000.0);
        testcheckingBalance = test_5_account.calcCheckingWithdraw(0.0);
        Assert.assertEquals(-100.0, testcheckingBalance);

        // amount = 0, checkingBalance > 0, amount < checkingBalance
        test_6_account = new Account(12345, 6789, 100.0, 2000.0);
        testcheckingBalance = test_6_account.calcCheckingWithdraw(0.0);
        Assert.assertEquals(100.0, testcheckingBalance);

        // amount < 0, checkingBalance = 0, amount < checkingBalance
        test_7_account = new Account(12345, 6789, 0.0, 2000.0);
        testcheckingBalance = test_7_account.calcCheckingWithdraw(-100.0);
        Assert.assertEquals(100.0, testcheckingBalance);

    }
}
