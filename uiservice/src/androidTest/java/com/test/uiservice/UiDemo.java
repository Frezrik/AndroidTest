package com.test.uiservice;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by Frezrik on 2017/10/13.
 */

@RunWith(AndroidJUnit4.class)
public class UiDemo {

    private UiDevice mUiDevice;

    @Before
    public void setUp() {
        mUiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void test() {
        mUiDevice.pressHome();
        assertTrue(false);
    }
}
