/* Copyright (C) 2023 <Jittiwat Sanit (can be multiple persons) - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the XYZ license. */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConstructorTest {

    @Test
    public void testConstructorA() {
        //ISP: Interface-Based (Relationship of every parameter to 0)
        try {
            //T1: customerNumber>0, pinNumber>0, checkingBalance>0, savingBalance>0
            new Account(1234,5678,1000,1000);
            //T2: customerNumber=0, pinNumber=0, checkingBalance=0, savingBalance=0
            new Account(0,0,0,0);
            //T3: customerNumber>0, pinNumber>0, checkingBalance>0, savingBalance<0
            new Account(1234,5678,1000,-1000);
            //T4: customerNumber>0, pinNumber>0, checkingBalance<0, savingBalance>0
            new Account(1234,5678,-1000,1000);
            //T5: customerNumber>0, pinNumber<0, checkingBalance>0, savingBalance>0
            new Account(1234,-5678,1000,1000);
            //T6: customerNumber<0, pinNumber>0, checkingBalance>0, savingBalance>0
            new Account(-1234,5678,1000,1000);
            //T7: customerNumber=0, pinNumber=0, checkingBalance=0, savingBalance=0
            new Account(0,0,0,-1000);
            //T8: customerNumber=0, pinNumber=0, checkingBalance<0, savingBalance=0
            new Account(0,0,-1000,0);
            //T9: customerNumber=0, pinNumber<0, checkingBalance=0, savingBalance=0
            new Account(0,-5678,0,0);
            //T10: customerNumber<0, pinNumber=0, checkingBalance=0, savingBalance=0
            new Account(-1234,0,0,0);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        //ISP: Functionality-Based (Object Account can retain its provided data after created)
        Account account = new Account(1234,5678,1000,1000);
        assertAll(
                //T11: account==instanceOf(Account), customerNumber==1234, pinNumber==5678, savingBalance==1000, checkingBalance==1000
                () -> assertEquals(account.getClass(), Account.class),
                () -> assertEquals(account.getCustomerNumber(),1234),
                () -> assertEquals(account.getPinNumber(),5678),
                () -> assertEquals(account.getSavingBalance(),1000),
                () -> assertEquals(account.getCheckingBalance(),1000)
        );
    }

    @Test
    public void testConstructorB() {
        //ISP: Interface-Based (Relationship of every parameter to 0)
        try {
            //T1: customerNumber>0, pinNumber>0
            new Account(1234,5678 );
            //T2: customerNumber=0, pinNumber=0
            new Account(0,0 );
            //T3: customerNumber>0, pinNumber<0
            new Account(1234,-5678 );
            //T4: customerNumber<0, pinNumber>0
            new Account(-1234,5678 );
            //T5: customerNumber=0, pinNumber<0
            new Account(0,-5678 );
            //T6: customerNumber<0, pinNumber=0
            new Account(-5678,0 );
        } catch (Exception e) {
            fail(e.getMessage());
        }
        //ISP: Functionality-Based (Object Account can retain its provided data after created)
        Account account = new Account(1234,5678);
        assertAll(
                //T7: account==instanceOf(Account), customerNumber==1234, pinNumber==5678
                () -> assertEquals(account.getClass(), Account.class),
                () -> assertEquals(account.getCustomerNumber(),1234),
                () -> assertEquals(account.getPinNumber(),5678)
        );
    }
}
