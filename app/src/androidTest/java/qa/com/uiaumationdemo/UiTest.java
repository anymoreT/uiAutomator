package qa.com.uiaumationdemo;

import android.os.RemoteException;
import android.support.test.uiautomator.UiAutomatorTestCase;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.content.Context;
import android.content.Intent;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import java.lang.Thread;

@RunWith(AndroidJUnit4.class)
 public class UiTest  {

    @Before
    public void before() {
        // Initialize UiDevice instance
        Device.set_device(UiDevice.getInstance(InstrumentationRegistry.getInstrumentation()));
        UiDevice mDevice =  Device.get_device();
        String packAgeName = mDevice.getCurrentPackageName();
        // Start from the home screen
        mDevice.pressHome();
        // open app
        Device.openApp("com.cebbank.bankebb");
    }

    @After
    public void after() throws RemoteException {
        Device.closeApp();
    }


//    public void openApp(String packageName) {
//        Context context = InstrumentationRegistry.getInstrumentation().getContext();
//        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        context.startActivity(intent);
//    }

         @Test
         public void testDemo() throws UiObjectNotFoundException {
             UiDevice mDevice =  Device.get_device();
             ElementUtil.wait_element_present(new UiSelector().resourceId("com.cebbank.bankebb:id/gv_item_tv_name1"));
             ElementUtil.wait_element_present(new UiSelector().text("登录"));
          }

    @Test
    public void testDemo1() throws UiObjectNotFoundException {
        UiDevice mDevice =  Device.get_device();
        ElementUtil.wait_element_present(new UiSelector().resourceId("com.cebbank.bankebb:id/gv_item_tv_name1"));
        ElementUtil.wait_element_present(new UiSelector().text("登录"));
        ElementUtil.wait_element_present(new UiSelector().resourceId("com.qunar.im.ui:id/self_gravatar"));
    }


    }
