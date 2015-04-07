package study.wp.ikitchen.utils;

/**
 * Created by wp on 2015-03-06.
 */

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

/**
 * 一些控件常见的操作
 * 1.控制控件的显示以及隐藏
 * 2.EditText内容是否为空
 */
public class WidgetControlUtils {
    public static void hideView(View view){
        if (view.getVisibility()==View.VISIBLE){
            view.setVisibility(View.GONE);
        }
    }
    public static void showView(View view){
        if (view.getVisibility()!=View.VISIBLE){
            view.setVisibility(View.VISIBLE);
        }
    }

    public static void isEditTextEmpty(EditText editText,String errorMsg){
        if(TextUtils.isEmpty(editText.getText().toString().trim())){
            editText.setError(errorMsg);
            return;
        }
    }

}
