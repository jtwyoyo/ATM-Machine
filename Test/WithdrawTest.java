/* Copyright (C) 2023 <Supakritt SurName(can be multiple persons) - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the XYZ license. */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WithdrawTest {
    @Test
    public void testcalcCheckingWithdraw(){
        // amount > 0, checkingBalance > 0, amount = checkingBalance
        Account test_1_account = new Account(12345, 6789, 100.0, 2000.0);
        Double testcheckingBalance = test_1_account.calcCheckingWithdraw(100.0);
        assertEquals(0, testcheckingBalance);

        // amount = 0, checkingBalance = 0, amount = checkingBalance
        Account test_2_account = new Account(12345, 6789, 0.0, 2000.0);
        testcheckingBalance = test_2_account.calcCheckingWithdraw(0.0);
        assertEquals(0, testcheckingBalance);

        // amount < 0, checkingBalance < 0, amount = checkingBalance
        Account test_3_account = new Account(12345, 6789, -100.0, 2000.0);
        testcheckingBalance = test_3_account.calcCheckingWithdraw(-100.0);
        assertEquals(0, testcheckingBalance);

        // amount > 0, checkingBalance = 0, amount > checkingBalance
        Account test_4_account = new Account(12345, 6789, 0.0, 2000.0);
        testcheckingBalance = test_4_account.calcCheckingWithdraw(100.0);
        assertEquals(-100.0, testcheckingBalance);

        // amount = 0, checkingBalance < 0, amount > checkingBalance
        Account test_5_account = new Account(12345, 6789, -100.0, 2000.0);
        testcheckingBalance = test_5_account.calcCheckingWithdraw(0.0);
        assertEquals(-100.0, testcheckingBalance);

        // amount = 0, checkingBalance > 0, amount < checkingBalance
        Account test_6_account = new Account(12345, 6789, 100.0, 2000.0);
        testcheckingBalance = test_6_account.calcCheckingWithdraw(0.0);
        assertEquals(100.0, testcheckingBalance);

        // amount < 0, checkingBalance = 0, amount < checkingBalance
        Account test_7_account = new Account(12345, 6789, 0.0, 2000.0);
        testcheckingBalance = test_7_account.calcCheckingWithdraw(-100.0);
        assertEquals(100.0, testcheckingBalance);
    }
}
