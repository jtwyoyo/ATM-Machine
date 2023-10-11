/* Copyright (C) 2023 <Thanakij Pinyoboon> - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the XYZ license. */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SetPinNumberTest {

    private Account account;
    Integer inputx = 1234;
    Integer inputy = 0;
    Integer inputz = -5678;


    @BeforeEach
    public void setUp() {
        account = new Account(12345, 6789);
    }

    @Test
    public void testCheckNotNull(){
        assertNotEquals(null, inputx);
        assertNotEquals(null, inputy);
        assertNotEquals(null, inputz);
    }

    @Test
    public void testSetPinNumber() {
        //Positive Pin Number (Greater than 0)
        Account x = new Account(1, 9999);
        int resultx = x.setPinNumber(inputx);
        assertEquals(1234, resultx);
        assertEquals(resultx, x.getPinNumber());
        //Functionality-based
        assertNotEquals(9999, resultx);

        //Zero Pin Number
        Account y = new Account(2, 9999);
        int resulty = y.setPinNumber(inputy);
        assertEquals(0, y.getPinNumber());
        assertEquals(resulty, y.getPinNumber());
        //Functionality-based
        assertNotEquals(9999, resulty);

        //Negative Pin Number (Less than 0)
        Account z = new Account(3, 9999);
        int resultz = z.setPinNumber(inputz);
        assertEquals(-5678, z.getPinNumber());
        assertEquals(resultz, z.getPinNumber());
        //Functionality-based
        assertNotEquals(9999, resultz);
    }
}