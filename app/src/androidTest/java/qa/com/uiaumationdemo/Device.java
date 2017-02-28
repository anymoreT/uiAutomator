package qa.com.uiaumationdemo;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import java.lang.Thread;
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

    public static void closeApp() throws RemoteException {
        try {
            if (get_device().pressRecentApps()) {
                Thread.sleep(1000);
                int startX = 300;
                int startY = 835;
                int endX = 1000;
                int endY = 835; // co-ordinates refer to x-axis from left of screen to right.
                int steps = 8;// speed at which the app closes
                get_device().swipe(startX, startY, endX, endY, steps);
            }
        }
        catch (Exception e){
            throw new RemoteException("关闭当前应用失败");
        }

    }


}
