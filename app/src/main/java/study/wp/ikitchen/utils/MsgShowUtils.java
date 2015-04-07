package study.wp.ikitchen.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by wp on 2015-03-26.
 */
public class MsgShowUtils {
    public static void showToast(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
