package com.test.androidtest;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Frezrik on 2017/10/2.
 */

@RunWith(AndroidJUnit4.class)
public class TestDemo {

    private UiDevice mDevice;


    @Test
    public void demo() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();
        mDevice.pressHome();
        UiObject uiObject = mDevice.findObject(new UiSelector().text("图库"));
        uiObject.click();

    }

}
