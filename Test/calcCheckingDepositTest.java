/* Copyright (C) 2023 <Wattanapong Sukchareonchok (can be multiple persons) - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the XYZ license. */

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class calcCheckingDepositTest {
        private Account account;
        @Test
        public void testCalcCheckingDeposit() {

            // Interface based characteristics
            // Test positive deposit amount=50.0, checkingBalance=100.0
            Account Account_t1 = new Account(12345, 6789, 100.0, 100.0);
            double amount_balance_t1 = 50.0;
            double newCheckingBalance_t1 = Account_t1.calcCheckingDeposit(amount_balance_t1);
            assertEquals(150.0, newCheckingBalance_t1);
            // Functionality based characteristics
            assertTrue(newCheckingBalance_t1 > amount_balance_t1);

            // Interface based characteristics
            // Test positive deposit amount=0.0, checkingBalance=100.0
            Account Account_t2 = new Account(12345, 6789, 100.0, 100.0);
            double amount_balance_t2 = 0.0;
            double newCheckingBalance_t2 = Account_t2.calcCheckingDeposit(amount_balance_t2);
            assertEquals(100.0, newCheckingBalance_t2);
            // Functionality based characteristics
            assertTrue(newCheckingBalance_t2 > amount_balance_t2);

            // Interface based characteristics
            // Test positive deposit amount=-50.0, checkingBalance=100.0
            Account Account_t3 = new Account(12345, 6789, 100.0, 100.0);
            double amount_balance_t3 = -50.0;
            double newCheckingBalance_t3 = Account_t3.calcCheckingDeposit(amount_balance_t3);
            assertEquals(50.0, newCheckingBalance_t3);
            // Functionality based characteristics
            assertTrue(newCheckingBalance_t3 > amount_balance_t3);

        }
        @Test
        public void testCalcSavingDeposit() {

            // Interface based characteristics
            // Test positive deposit amount=50.0, checkingBalance=100.0
            Account Account_tt1 = new Account(12345, 6789, 100.0, 100.0);
            double amount_save_t1 = 50.0;
            double newSavingBalance_t1 = Account_tt1.calcSavingDeposit(amount_save_t1);
            assertEquals(150.0, newSavingBalance_t1);
            // Functionality based characteristics
            assertTrue(newSavingBalance_t1 > amount_save_t1);

            // Interface based characteristics
            // Test positive deposit amount=0.0, checkingBalance=100.0
            Account Account_tt2 = new Account(12345, 6789, 100.0, 100.0);
            double amount_save_t2 = 0.0;
            double newSavingBalance_t2 = Account_tt2.calcSavingDeposit(amount_save_t2);
            assertEquals(100.0, newSavingBalance_t2);
            // Functionality based characteristics
            assertTrue(newSavingBalance_t2 > amount_save_t2);

            // Interface based characteristics
            // Test positive deposit amount=-50.0, checkingBalance=100.0
            Account Account_tt3 = new Account(12345, 6789, 100.0, 100.0);
            double amount_save_t3 = -50.0;
            double newSavingBalance_t3 = Account_tt3.calcSavingDeposit(-amount_save_t3);
            assertEquals(50, newSavingBalance_t3);
            // Functionality based characteristics
            assertTrue(newSavingBalance_t3 > amount_save_t3);
        }
    }
