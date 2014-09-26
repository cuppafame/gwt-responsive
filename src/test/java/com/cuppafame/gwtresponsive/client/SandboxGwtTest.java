package com.cuppafame.gwtresponsive.client;

import com.google.gwt.junit.client.GWTTestCase;

public class SandboxGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "com.cuppafame.gwtresponsive.GWTResponsive";
    }

    public void testSandbox() {
        assertTrue(true);
    }
}
