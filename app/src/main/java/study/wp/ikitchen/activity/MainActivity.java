package study.wp.ikitchen.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import study.wp.ikitchen.R;
import study.wp.ikitchen.application.IKitchenApp;
import study.wp.ikitchen.fregment.CookBookFragment;
import study.wp.ikitchen.fregment.HomeFragment;
import study.wp.ikitchen.fregment.MemberFragment;
import study.wp.ikitchen.fregment.MenuFragment;
import study.wp.ikitchen.fregment.RankFragment;
import study.wp.ikitchen.utils.PreferenceUtils;
import study.wp.ikitchen.utils.WidgetControlUtils;


public class MainActivity extends ActionBarActivity implements RadioGroup.OnCheckedChangeListener{
    public RadioGroup bottombar;
    public int bottomCheckId;
    private HomeFragment homeFragment;
    private RankFragment rankFragment;
    private MemberFragment memberFragment;
    private CookBookFragment cookBookFragment;
    private MenuFragment menuFragment;

    private View headbar;
    private LinearLayout backll;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        //actionbar处理
        headbar=(View)findViewById(R.id.head_bar);
        backll=(LinearLayout)findViewById(R.id.back_ll);
        title=(TextView)findViewById(R.id.title_textview);
        backll.setVisibility(View.GONE);

        bottombar=(RadioGroup)findViewById(R.id.bottombar_container);
        bottombar.setOnCheckedChangeListener(this);
        setCurrentItem(R.id.tab_menu_1);

    }

    //更改frament局部内容
    private void setCurrentItem(int checkid) {
        Fragment fragment=null;
        switch (checkid){
            case R.id.tab_menu_1:
                if (homeFragment==null) homeFragment=new HomeFragment();
                fragment=homeFragment;
                bottomCheckId=checkid;
                title.setText("首页");
                WidgetControlUtils.showView(headbar);
                break;
            case R.id.tab_menu_2:
                if (menuFragment==null) menuFragment=new MenuFragment();
                fragment=menuFragment;
                bottomCheckId=checkid;
                title.setText("菜谱");
                WidgetControlUtils.showView(headbar);
                break;
            case R.id.tab_menu_3:
                if (rankFragment==null) rankFragment=new RankFragment();
                fragment=rankFragment;
                bottomCheckId=checkid;
                title.setText("排行");
                WidgetControlUtils.showView(headbar);
                break;
            case R.id.tab_menu_4:
                if (cookBookFragment==null) cookBookFragment=new CookBookFragment();
                fragment=cookBookFragment;
                bottomCheckId=checkid;
                title.setText("菜单");
                WidgetControlUtils.showView(headbar);
                break;
            case R.id.tab_menu_5:
                if (memberFragment==null) memberFragment=new MemberFragment();
                fragment=memberFragment;
                bottomCheckId=checkid;
                title.setText("个人中心");
                WidgetControlUtils.hideView(headbar);
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
    }

    private void userlogoff() {
        IKitchenApp.getInstance().setUser(null);
        IKitchenApp.getInstance().setIsLogin(false);
        PreferenceUtils.putString(this, "mobile",null);
        PreferenceUtils.putString(this,"password",null);
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        setCurrentItem(checkedId);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
