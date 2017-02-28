package qa.com.uiaumationdemo;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
/**
 * Created by benhuang on 2017/2/28.
 */

public class Device {
    //全局device
    public static UiDevice device;

    //设置device
    public static void set_device(UiDevice device){
        Device.device = device;
    }

    //获取device
    public static UiDevice get_device(){
        return Device.device;
    }

    public static void openApp(String packageName) {
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }


}
