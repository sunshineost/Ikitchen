package study.wp.ikitchen.utils;

import android.content.Context;

import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import study.wp.ikitchen.application.IKitchenApp;
import study.wp.ikitchen.model.response.LoginResult;

/**
 * Created by wp on 2015-04-02.
 * 更新用户信息
 */
public class UserUtils {
    public static void  relogin(final Context context){
        Ion.with(context).load(ApplicationParams.http_url_login).setMultipartParameter("mobile", IKitchenApp.getInstance().getUser().getMobile())
                .setMultipartParameter("password",PreferenceUtils.getString(context, "password"))
                .as(new TypeToken<LoginResult>(){})
                .withResponse()
                .setCallback(new FutureCallback<Response<LoginResult>>() {
                    @Override
                    public void onCompleted(Exception e, Response<LoginResult> result) {
                            if (result.getResult().getStatus().equals("success")){
                                MsgShowUtils.showToast(context,"更新数据成功");
                                IKitchenApp.getInstance().setUser(result.getResult().getUser());
                            }else {
                                MsgShowUtils.showToast(context,"更新用户数据失败");
                            }
                    }
                });

    }
}
