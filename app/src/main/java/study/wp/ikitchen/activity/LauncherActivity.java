package study.wp.ikitchen.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.i5tong.wtandroid.http.WTHttpUtils;
import com.i5tong.wtandroid.http.interface2.OnWTHttpRequestCompleteCallback;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import study.wp.ikitchen.R;
import study.wp.ikitchen.application.IKitchenApp;
import study.wp.ikitchen.model.User;
import study.wp.ikitchen.model.response.GetCommonProResult;
import study.wp.ikitchen.model.response.LoginResult;
import study.wp.ikitchen.utils.ApplicationParams;
import study.wp.ikitchen.utils.PreferenceUtils;

/**
 * Created by wp on 2015-03-04.
 */
public class LauncherActivity extends Activity {
    static String TAG = "LaucherActivity";
    private Handler handler = new Handler();
    WTHttpUtils wtHttpUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wtHttpUtils = new WTHttpUtils(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_launcher);
        getCommonProperties();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //是否要进入引导界面 pre isFirstLogin=false;
                if (PreferenceUtils.getBoolean(LauncherActivity.this, "isFirstLogin", true)) {
                    //第一次进入，进入引导界面
                    Intent intent=new Intent(LauncherActivity.this,GuideActivity.class);
                    startActivity(intent);
                } else {
                    //第N词进入，登陆界面或者预登陆至主界面或者用户中心
                    Login();
                }
            }
        }, 3000);


    }

    /**
     * 登陆处理，如果以前登陆未注销，那么预登陆，如果登陆注销，则到登陆界面
     */
    private void Login() {
        if ((!TextUtils.isEmpty(PreferenceUtils.getString(this, "mobile"))) && (!TextUtils.isEmpty(PreferenceUtils.getString(this, "password")))) {
            doLogin(PreferenceUtils.getString(this, "mobile"), PreferenceUtils.getString(this, "password"));
        } else {
            Intent intent = new Intent(LauncherActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }

    private void doLogin(final String mobile, final String password) {
        wtHttpUtils.setProgressDialogMessage("登陆中");
        Map<String, Object> map = new HashMap<>();
        map.put("mobile",mobile);
        map.put("password",password);
        wtHttpUtils.doHttpRequest(ApplicationParams.http_url_login,WTHttpUtils.HTTP_POST,map, LoginResult.class,new OnWTHttpRequestCompleteCallback() {
            @Override
            public void success(String s) {

            }

            @Override
            public void fail(String s) {
              Toast.makeText(LauncherActivity.this,"预登陆失败，即将掉转到登陆界面！",Toast.LENGTH_SHORT).show();
              handler.postDelayed(new Runnable() {
                  @Override
                  public void run() {
                      Intent intent=new Intent(LauncherActivity.this,LoginActivity.class);
                      startActivity(intent);
                  }
              },3000);
            }

            @Override
            public void json(Map<String, Object> map) {

            }

            @Override
            public void json(Object o) {
                LoginResult loginResult=(LoginResult) o;
                if (loginResult.getStatus().equals("success")){
                    User user=loginResult.getUser();
                    IKitchenApp.getInstance().setUser(user);
                    IKitchenApp.getInstance().setIsLogin(true);
                    PreferenceUtils.putString(LauncherActivity.this,"mobile",mobile);
                    PreferenceUtils.putString(LauncherActivity.this,"password",password);
                    Toast.makeText(LauncherActivity.this,"登陆成功！",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LauncherActivity.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LauncherActivity.this,loginResult.getErrorMsg(),Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    /**
     * 获取常用数据
     */
    private void getCommonProperties() {
        wtHttpUtils.doHttpRequest(ApplicationParams.http_url_get_common_properties, WTHttpUtils.HTTP_POST, null, GetCommonProResult.class, new OnWTHttpRequestCompleteCallback() {
            @Override
            public void success(String s) {

            }

            @Override
            public void fail(String s) {
                Toast.makeText(LauncherActivity.this, "获取数据失败！", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void json(Map<String, Object> map) {

            }

            @Override
            public void json(Object o) {
                GetCommonProResult getCommonProResult = (GetCommonProResult) o;
                if (getCommonProResult != null) {
                    if (getCommonProResult.getStatus().equals("success")) {
                        IKitchenApp.getInstance().setpCookpeopleList(getCommonProResult.getPcookpeopleList());
                        IKitchenApp.getInstance().setpCooktimeList(getCommonProResult.getPcooktimeList());
                        IKitchenApp.getInstance().setpCookwayList(getCommonProResult.getPcookwayList());
                        IKitchenApp.getInstance().setpHardlevelList(getCommonProResult.getPhardlevelList());
                        IKitchenApp.getInstance().setpTasteList(getCommonProResult.getPtasteList());
                        IKitchenApp.getInstance().setTypeList(getCommonProResult.getTypeList());
                        IKitchenApp.getInstance().setTagdataList(getCommonProResult.getTagdataList());
                        Log.e(TAG, "GetCommonProperties complate" + new Date().toString());
                    } else {
                        Toast.makeText(LauncherActivity.this, "获取数据失败！", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LauncherActivity.this, "获取数据失败！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
