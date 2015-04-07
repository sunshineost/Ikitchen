package study.wp.ikitchen.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.i5tong.wtandroid.http.WTHttpUtils;
import com.i5tong.wtandroid.http.interface2.OnWTHttpRequestCompleteCallback;

import java.util.HashMap;
import java.util.Map;

import study.wp.ikitchen.R;
import study.wp.ikitchen.application.IKitchenApp;
import study.wp.ikitchen.model.User;
import study.wp.ikitchen.model.response.LoginResult;
import study.wp.ikitchen.utils.ApplicationParams;
import study.wp.ikitchen.utils.PreferenceUtils;

public class LoginActivity extends ActionBarActivity {

    WTHttpUtils wtHttpUtils;
    EditText mobile_et,password_et;
    Button login_bt,register_bt;
    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        wtHttpUtils=new WTHttpUtils(this);
        initLayout();
    }

    private void initLayout() {
        mobile_et=(EditText)findViewById(R.id.mobile_et);
        password_et=(EditText)findViewById(R.id.password_et);
        login_bt=(Button)findViewById(R.id.login_bt);
        register_bt=(Button)findViewById(R.id.register_bt);
        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Login();
            }
        });
        register_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Login() {
        //判断数据是否为空
        if (TextUtils.isEmpty(mobile_et.getText().toString().trim())){
            mobile_et.setError("用户名不能为空！");
            return;
        }
        if (TextUtils.isEmpty(password_et.getText().toString().trim())){
            password_et.setError("密码不能为空！");
            return;
        }
        doLogin(mobile_et.getText().toString().trim(),password_et.getText().toString().trim());
    }

    private void doLogin(String mobile, String password) {
        wtHttpUtils.setProgressDialogMessage("登陆中");
        Map<String, Object> map = new HashMap<>();
        map.put("mobile",mobile_et.getText().toString().trim());
        map.put("password",password_et.getText().toString().trim());
        wtHttpUtils.doHttpRequest(ApplicationParams.http_url_login,WTHttpUtils.HTTP_POST,map, LoginResult.class,new OnWTHttpRequestCompleteCallback() {
            @Override
            public void success(String s) {

            }

            @Override
            public void fail(String s) {
                Toast.makeText(LoginActivity.this,"登陆失败！",Toast.LENGTH_SHORT).show();
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
                    PreferenceUtils.putString(LoginActivity.this,"mobile",mobile_et.getText().toString().trim());
                    PreferenceUtils.putString(LoginActivity.this,"password",password_et.getText().toString().trim());
                    Toast.makeText(LoginActivity.this,"登陆成功！",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this,loginResult.getErrorMsg(),Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
