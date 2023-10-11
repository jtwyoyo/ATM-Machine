/* Copyright (C) 2023 <Apichaya Maneewong (can be multiple persons) - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the XYZ license. */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TransferTest {
    private Account account;
    private Account account2;
    private Account account3;
    private Account account4;

    private Double amount;
    private Double amount2;
    private Double amount3;

    private Double checkingBalance;
    private Double savingBalance;

    @BeforeEach
    public void setup(){
        checkingBalance = 1000.0;
        savingBalance = 2000.0;
        account = new Account(12345, 6789, checkingBalance, savingBalance);
        account2 = new Account(6789, 12345, checkingBalance, savingBalance);
        account3 = new Account(57485, 1478, -1000, -2000);
        account4 = new Account(45458, 9654, 0, 0);
        amount = 100.0;
        amount2 = -100.0;
        amount3 = 0.0;
    }
    @Test
    public void testTransferInterface(){
//  C1 = relation of amount to 0
//  C2 = relation of checking Balance to 0
//  C3 = relation of saving Balance to 0
//  T1(Less than 0,Less than 0, Less than 0)
        assertTrue(this.amount2 < 0
                && this.account3.getCheckingBalance() < 0
                && this.account3.getSavingBalance() < 0);
        assertEquals(-100,this.amount2);
        assertEquals(-1000,this.account3.getCheckingBalance());
        assertEquals(-2000,this.account3.getSavingBalance());
//  T2(Equal to 0, Equal to 0, Equal to 0)
        assertTrue(this.amount3 == 0
                && this.account4.getCheckingBalance() == 0
                && this.account4.getSavingBalance() == 0);
        assertEquals(0,this.amount3);
        assertEquals(0,this.account4.getCheckingBalance());
        assertEquals(0,this.account4.getSavingBalance());
//  T3(Greater than 0, Greater than 0,Greater than 0)
        assertTrue(this.amount > 0
                && this.account.getCheckingBalance() > 0
                && this.account.getSavingBalance() > 0);
        assertEquals(100,this.amount);
        assertEquals(1000,this.account.getCheckingBalance());
        assertEquals(2000,this.account.getSavingBalance());
    }


    @Test
    public void testcalcCheckTransfer(){
//  C1 = Values of checkingBalance after call calcCheckTransfer method < old checkingBalance
//  C2 = Values of savingBalance after call calcCheckTransfer method > old savingBalance
//      parameter (amount = 100)
        account.calcCheckTransfer(amount);
//      T1(True,True)
        assertTrue( account.getCheckingBalance() < this.checkingBalance &&  account.getSavingBalance() > this.savingBalance);
        assertEquals(900.0,account.getCheckingBalance());
        assertEquals(2100.0,account.getSavingBalance());

//      T2(False,False)
        account2.calcCheckTransfer(amount2);
        assertFalse( account2.getCheckingBalance() < this.checkingBalance &&  account.getSavingBalance() > this.savingBalance);
        assertEquals(1100.0,account2.getCheckingBalance());
        assertEquals(1900.0,account2.getSavingBalance());
    }

    @Test
    public void testcalcSavingTransfer(){
//  C1 = Values of checkingBalance after call calcCheckTransfer method > old checkingBalance
//  C2 = Values of savingBalance after call calcCheckTransfer method < old savingBalance
//      parameter (amount = 100)
        account.calcSavingTransfer(amount);
//      T1(True,True)
        assertTrue( account.getCheckingBalance() > this.checkingBalance &&  account.getSavingBalance() < this.savingBalance);
        assertEquals(1100.0,account.getCheckingBalance());
        assertEquals(1900.0,account.getSavingBalance());

//      T2(False,False)
        account2.calcSavingTransfer(amount2);
        assertFalse( account2.getCheckingBalance() > this.checkingBalance &&  account.getSavingBalance() < this.savingBalance);
        assertEquals(900.0,account2.getCheckingBalance());
        assertEquals(2100.0,account2.getSavingBalance());
    }
}

//    @Test
//    public void testcalcSavingTransfer(){
//        account.calcSavingTransfer(amount);
////  C1 = Values of checkingBalance after the calculation with amount value.
////      checkingBalance value has decreased by the value of the amount
//        assertNotEquals(900.0,account.getCheckingBalance());
////      checkingBalance value should not still the same
//        assertNotEquals(1000.0,account.getCheckingBalance());
////      checkingBalance value should not increase by the value of the amount
//        assertEquals(1100.0,account.getCheckingBalance());
//
////  C2 = Values of savingingBalance after the calculation with amount value.
////      savingBalance value should not decrease by the value of the amount
//        assertEquals(1900.0,account.getSavingBalance());
////      savingBalance value should not still the same
//        assertNotEquals(2000.0,account.getSavingBalance());
////      savingBalance value has increased by the value of the amount
//        assertNotEquals(2100.0,account.getSavingBalance());
//    }
