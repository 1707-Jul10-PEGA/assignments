package com.wh.banking_appTests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wh.banking_app.Application;

public class ApplicationTest {
    
    static Application ap;
    
    @BeforeClass
    public static void setup() {
	ap = new Application();
    }

    @Test
    public void statusTest() {
	assertSame(ap.status(), "PENDING");
	ap.approve();
	assertSame(ap.status(), "APPROVED");
	ap.deny();
	assertSame(ap.status(), "DENIED");
    }

    @Test
    public void approveTest() {
	assertTrue(ap.approve());
	assertSame(ap.status(), "APPROVED");
    }
    
    @Test
    public void denyTest() {
	assertFalse(ap.deny());
	assertSame(ap.status(), "DENIED");
    }
}
