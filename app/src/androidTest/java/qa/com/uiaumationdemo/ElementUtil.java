package qa.com.uiaumationdemo;

/**
 * Created by benhuang on 2017/2/28.
 */

import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiSelector;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiObject;
import android.view.accessibility.AccessibilityNodeInfo;

import java.lang.Thread;

public class ElementUtil {
    public static void  wait_element_present(UiSelector selector) throws UiObjectNotFoundException{

        int reTry = 6;
        long interval = 10000;
        UiDevice mDevice = Device.get_device();
        for (int i = 0; i <= reTry; i++) {
            UiObject obj =  mDevice.findObject(selector);
            boolean flag = obj.waitForExists(interval);
            if (flag) return ;
            if (i >= reTry) {
                throw new UiObjectNotFoundException(obj.toString());
            }

        }
    }

}


