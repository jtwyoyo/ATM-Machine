/* Copyright (C) 2023 <Thanakij Pinyoboon> - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the XYZ license. */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalcSavingWithdrawTest {

    private Account account;
    private double amount = 100.0;

    @BeforeEach
    public void setUp() {
        account = new Account(12345, 6789, 1000.0, 2000.0);
    }

    @Test
    public void testCheckNotNull(){
        assertNotEquals(null, amount);
        assertNotEquals(null, account.getSavingBalance());
    }

    @Test
    public void testCalcSavingWithdrawNormal(){
        account.calcSavingTransfer(amount);
        assertEquals(1900.0,account.getSavingBalance());
    }

    @Test
    public void testCalcSavingWithdraw() {
        double amountx = 100; //amount is greater than 0
        double amounty = 0; //amount is equal to 0
        double amountz = -100; //amount is less than 0

        //amount = 100, saving balance is 100, amount = savingBalance
        Account x = new Account(1, 1234, 0, 100);
        double newBalancexx = x.calcSavingWithdraw(amountx);
        assertEquals(0, newBalancexx);
        assertEquals(newBalancexx, x.getSavingBalance());

        //amount = 100, saving balance is 0,  amount > savingBalance
        Account y = new Account(2, 0, 0, 0);
        double newBalanceyx = y.calcSavingWithdraw(amountx);
        assertEquals(-100, newBalanceyx);
        assertEquals(newBalanceyx, y.getSavingBalance());

        //amount = 0, saving balance is 100,  amount < savingBalance
        Account x2 = new Account(3, 1234, 0, 100);
        double newBalancexy = x2.calcSavingWithdraw(amounty);
        assertEquals(100, newBalancexy);
        assertEquals(newBalancexy, x2.getSavingBalance());


        //amount = 0, saving balance is 0,  amount = savingBalance
        Account y2 = new Account(4, 0, 0, 0);
        double newBalanceyy = y2.calcSavingWithdraw(amounty);
        assertEquals(0, newBalanceyy);
        assertEquals(newBalanceyy, y2.getSavingBalance());

        //amount = 0, saving balance is -100,  amount > savingBalance
        Account z2 = new Account(5, 4567, 0, -100);
        double newBalancezy = z2.calcSavingWithdraw(amounty);
        assertEquals(-100, newBalancezy);
        assertEquals(newBalancezy, z2.getSavingBalance());


        //amount = -100, saving balance is 100,  amount < savingBalance
        Account x3 = new Account(6, 1234, 0, 100);
        double newBalancexz = x3.calcSavingWithdraw(amountz);
        assertEquals(200, newBalancexz);
        assertEquals(newBalancexz, x3.getSavingBalance());

        //amount = -100, saving balance is -100,  amount = savingBalance
        Account z3 = new Account(7, 4567, 0, -100);
        double newBalancezz = z3.calcSavingWithdraw(amountz);
        assertEquals(0, newBalancezz);
        assertEquals(newBalancezz, z3.getSavingBalance());
    }
}