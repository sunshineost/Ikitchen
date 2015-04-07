package study.wp.ikitchen.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.i5tong.wtandroid.http.WTHttpUtils;
import com.i5tong.wtandroid.http.interface2.OnWTHttpRequestCompleteCallback;

import org.w3c.dom.Text;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import study.wp.ikitchen.R;
import study.wp.ikitchen.activity.test.TestZingActivity;
import study.wp.ikitchen.application.IKitchenApp;
import study.wp.ikitchen.model.User;
import study.wp.ikitchen.model.response.RegisterResult;
import study.wp.ikitchen.utils.ApplicationParams;
import study.wp.ikitchen.utils.FileUtils;
import study.wp.ikitchen.utils.PreferenceUtils;

public class RegisterActivity extends ActionBarActivity implements View.OnClickListener{
    LinearLayout first_ll,second_ll,third_ll,forth_ll;
    Button to_second_bt,to_three_bt,getvc_bt,register_bt,to_complete_bt,to_member_bt;
    EditText mobile_et,vc_et,nickname_et,password_et,check_password_et;
    TextView mobile_tv,mobile2_tv;
    LinearLayout back_ll;
    TextView title_tv;
    int curPage=1;
    String mobile;

    WTHttpUtils wtHttpUtils;
    Handler handler=new Handler();
    int s=60;

    //二维码

    final int QR_WIDTH = 300;
    final int QR_HEIGHT = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);
        wtHttpUtils=new WTHttpUtils(this);
        initLayout();
    }

    private void initLayout() {
        first_ll=(LinearLayout)findViewById(R.id.first_step_ll);
        second_ll=(LinearLayout)findViewById(R.id.second_step_ll);
        third_ll=(LinearLayout)findViewById(R.id.third_step_ll);
        forth_ll=(LinearLayout)findViewById(R.id.forth_step_ll);

        to_second_bt=(Button)findViewById(R.id.to_second_bt);
        getvc_bt=(Button)findViewById(R.id.getvc_bt);
        to_three_bt=(Button)findViewById(R.id.tothree_bt);
        register_bt=(Button)findViewById(R.id.register_bt);
        to_complete_bt=(Button)findViewById(R.id.to_complete_bt);
        to_member_bt=(Button)findViewById(R.id.to_menmber_bt);

        mobile_et=(EditText)findViewById(R.id.mobile_et);
        vc_et=(EditText)findViewById(R.id.vc_et);
        nickname_et=(EditText)findViewById(R.id.nicname_et);
        password_et=(EditText)findViewById(R.id.password_et);
        check_password_et=(EditText)findViewById(R.id.check_password_et);
        mobile_tv=(TextView)findViewById(R.id.mobile_tv);
        mobile2_tv=(TextView)findViewById(R.id.mobile2_tv);

        back_ll=(LinearLayout)findViewById(R.id.back_ll);
        title_tv=(TextView)findViewById(R.id.title_textview);

        to_second_bt.setOnClickListener(this);
        to_three_bt.setOnClickListener(this);
        getvc_bt.setOnClickListener(this);
        register_bt.setOnClickListener(this);
        to_complete_bt.setOnClickListener(this);
        to_member_bt.setOnClickListener(this);
        back_ll.setOnClickListener(this);

        updateLayout();

    }

    private void updateLayout() {
        switch (curPage){
            case 1:
                if (second_ll.getVisibility()==View.VISIBLE){
                    second_ll.setVisibility(View.GONE);
                }
                if (third_ll.getVisibility()==View.VISIBLE){
                    third_ll.setVisibility(View.GONE);
                }
                if (forth_ll.getVisibility()==View.VISIBLE){
                    forth_ll.setVisibility(View.GONE);
                }
                if(first_ll.getVisibility()!=View.VISIBLE){
                    first_ll.setVisibility(View.VISIBLE);
                }
                title_tv.setText("注册(1/3)");
                break;
            case 2:
                if (first_ll.getVisibility()==View.VISIBLE){
                    first_ll.setVisibility(View.GONE);
                }
                if (third_ll.getVisibility()==View.VISIBLE){
                    third_ll.setVisibility(View.GONE);
                }
                if (forth_ll.getVisibility()==View.VISIBLE){
                    forth_ll.setVisibility(View.GONE);
                }
                if(second_ll.getVisibility()!=View.VISIBLE){
                    second_ll.setVisibility(View.VISIBLE);
                }
                title_tv.setText("注册(2/3)");
                break;
            case 3:
                if (first_ll.getVisibility()==View.VISIBLE){
                    first_ll.setVisibility(View.GONE);
                }
                if (second_ll.getVisibility()==View.VISIBLE){
                    second_ll.setVisibility(View.GONE);
                }
                if (forth_ll.getVisibility()==View.VISIBLE){
                    forth_ll.setVisibility(View.GONE);
                }
                if(third_ll.getVisibility()!=View.VISIBLE){
                    third_ll.setVisibility(View.VISIBLE);
                }
                title_tv.setText("注册(3/3)");
                break;
            case 4:
                if (first_ll.getVisibility()==View.VISIBLE){
                    first_ll.setVisibility(View.GONE);
                }
                if (second_ll.getVisibility()==View.VISIBLE){
                    second_ll.setVisibility(View.GONE);
                }
                if (third_ll.getVisibility()==View.VISIBLE){
                    third_ll.setVisibility(View.GONE);
                }
                if(forth_ll.getVisibility()!=View.VISIBLE){
                    forth_ll.setVisibility(View.VISIBLE);
                }
                title_tv.setText("注册成功");
                break;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.to_second_bt:
                //到第二页之前，验证手机号是否已经存在，存在的话则提示，不存在到下一步
                 isExistMobile();
                break;
            case R.id.tothree_bt:
                curPage=3;
                updateLayout();
                mobile2_tv.setText(mobile);
                break;
            case R.id.register_bt:
                register();

                break;
            case R.id.back_ll:
            {
                switch (curPage){
                    case 1:
                        finish();
                        break;
                    case 2:
                        curPage=1;
                        updateLayout();
                        break;
                    case 3:
                        curPage=2;
                        updateLayout();
                        break;
                    case 4:
                        curPage=3;
                        updateLayout();
                        break;
                }
            }
            case R.id.getvc_bt:
                getVCCode(mobile);
                break;
            case R.id.to_menmber_bt:
                Intent intent=new Intent(RegisterActivity.this, TestZingActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void register() {
        if (TextUtils.isEmpty(nickname_et.getText().toString().trim())){
            nickname_et.setError("昵称不能为空！");
            return;
        }
        if (TextUtils.isEmpty(password_et.getText().toString().trim())){
            password_et.setError("密码不能为空！");
            return;
        }
        if (TextUtils.isEmpty(check_password_et.getText().toString().trim())){
            check_password_et.setError("确认密码不能为空！");
            return;
        }
        if (!check_password_et.getText().toString().trim().equals(password_et.getText().toString().trim())){
            check_password_et.setError("两次密码不一致！");
            return;
        }
        Bitmap qrcode=createQRcode("ikitchen_user_"+String.valueOf(mobile));
        File qrfile=new FileUtils().write2SDFromBitmap("/IKUserData/userQRCode","ikitchen_user_"+String.valueOf(mobile)+".png",qrcode);

        Map<String,Object> map=new HashMap<>();
        map.put("mobile",mobile);
        map.put("password",password_et.getText().toString().trim());
        map.put("nickname",nickname_et.getText().toString().trim());
        map.put("sid","233");
        map.put("qrcode",qrfile);
        wtHttpUtils.setProgressDialogMessage("注册中");
        wtHttpUtils.doHttpRequest(ApplicationParams.http_url_regitster,WTHttpUtils.HTTP_POST,map,RegisterResult.class,new OnWTHttpRequestCompleteCallback() {
            @Override
            public void success(String s) {

            }

            @Override
            public void fail(String s) {

            }

            @Override
            public void json(Map<String, Object> map) {

            }

            @Override
            public void json(Object o) {
                RegisterResult registerResult=(RegisterResult)o;
                if(registerResult.getStatus().equals("success")){
                    User u=registerResult.getUser();
                    IKitchenApp.getInstance().setUser(u);
                    IKitchenApp.getInstance().setIsLogin(true);
                    PreferenceUtils.putString(RegisterActivity.this, "mobile", u.getMobile());
                    PreferenceUtils.putString(RegisterActivity.this,"password",password_et.getText().toString().trim());
                    Toast.makeText(RegisterActivity.this,"注册成功！",Toast.LENGTH_SHORT).show();
                    curPage=4;
                    updateLayout();
                }else{
                    Toast.makeText(RegisterActivity.this,registerResult.getErrorMsg(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Bitmap createQRcode(String str) {

        try {
            QRCodeWriter writer=new QRCodeWriter();
            HashMap<EncodeHintType,String> hints=new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");
            BitMatrix bitMatrix = new QRCodeWriter().encode(str,
                    BarcodeFormat.QR_CODE, QR_WIDTH, QR_HEIGHT, hints);
            int[] pixels = new int[QR_WIDTH * QR_HEIGHT];
            for (int y = 0; y < QR_HEIGHT; y++) {
                for (int x = 0; x < QR_WIDTH; x++) {
                    if (bitMatrix.get(x, y)) {
                        pixels[y * QR_WIDTH + x] = 0xff000000;
                    } else {
                        pixels[y * QR_WIDTH + x] = 0xffffffff;
                    }

                }
            }
            Bitmap bitmap = Bitmap.createBitmap(QR_WIDTH, QR_HEIGHT,
                    Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, QR_WIDTH, 0, 0, QR_WIDTH, QR_HEIGHT);
            return bitmap;

        } catch (WriterException e) {
            e.printStackTrace();
        }
         return null;
    }

    private void getVCCode(String mobile) {



        s=60;
        handler.post(new Runnable() {
            @Override
            public void run() {
            if(s>0) {
                getvc_bt.setBackgroundColor(R.drawable.bg_btn_grey_radius);
                getvc_bt.setText(s+"秒后重新获取");
                getvc_bt.setClickable(false);
                getvc_bt.setTextColor(Color.BLACK);
            }
            if(s==0){
                getvc_bt.setBackgroundColor(R.drawable.bg_btn_red_radius);
                getvc_bt.setText("获取验证码");
                getvc_bt.setClickable(true);
                getvc_bt.setTextColor(Color.WHITE);
            }
            }
        });
    }

    private void isExistMobile() {
        if (TextUtils.isEmpty(mobile_et.getText().toString().trim())){
            mobile_et.setError("手机不能为空");
            return;
        }
        if (mobile_et.getText().toString().trim().length()!=11){
            mobile_et.setError("请输入正确的手机号！");
            return;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("mobile",mobile_et.getText().toString().trim());
        wtHttpUtils.doHttpRequest(ApplicationParams.http_url_regitster,WTHttpUtils.HTTP_POST,map, RegisterResult.class,new OnWTHttpRequestCompleteCallback() {
            @Override
            public void success(String s) {

            }

            @Override
            public void fail(String s) {
                mobile=mobile_et.getText().toString().trim();
                curPage=2;
                mobile_tv.setText(mobile);
                updateLayout();
            }

            @Override
            public void json(Map<String, Object> map) {

            }

            @Override
            public void json(Object o) {
                  Toast.makeText(RegisterActivity.this,"手机号已存在！",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
