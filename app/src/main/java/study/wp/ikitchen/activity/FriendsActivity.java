package study.wp.ikitchen.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.i5tong.wtandroid.http.WTHttpUtils;
import com.i5tong.wtandroid.http.interface2.OnWTHttpRequestCompleteCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import java.net.ResponseCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import study.wp.ikitchen.R;
import study.wp.ikitchen.adapter.FriendsAdapter;
import study.wp.ikitchen.application.IKitchenApp;
import study.wp.ikitchen.model.Concern;
import study.wp.ikitchen.model.User;
import study.wp.ikitchen.model.response.ConcernResult;
import study.wp.ikitchen.model.response.GetFriendsResult;
import study.wp.ikitchen.utils.ApplicationParams;
import study.wp.ikitchen.utils.MsgShowUtils;
import study.wp.ikitchen.utils.UserUtils;
import study.wp.ikitchen.utils.WidgetControlUtils;

/**
 * Created by wp on 2015-03-26.
 */
public class FriendsActivity extends Activity implements View.OnClickListener, FriendsAdapter.AddFollow {
    //标题栏
    View headbar;
    LinearLayout backll;
    TextView title_textview;
    ImageView img_menu;
    //区分是我关注的人，还是关注我的人。
    Boolean isFan = false;
    //页面数据
    ListView listview;
    TextView nodata_tv;
    List<User> userList = new ArrayList<>();
    FriendsAdapter friendsAdapter;

    WTHttpUtils wtHttpUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        isFan = getIntent().getBooleanExtra("isFan", false);
        wtHttpUtils = new WTHttpUtils(this);
        initActionbar();
        initLayout();
        getData();
    }

    private void initLayout() {
        backll.setOnClickListener(this);
        img_menu.setOnClickListener(this);
        listview = (ListView) findViewById(R.id.listview);
        nodata_tv = (TextView) findViewById(R.id.nodata_tv);
        if (isFan) {
            if (IKitchenApp.getInstance().getUser().getConcernsForConcernuid().size() == 0) {
                WidgetControlUtils.hideView(listview);
                WidgetControlUtils.showView(nodata_tv);
                nodata_tv.setText("没有数据");
            } else {
                WidgetControlUtils.showView(listview);
                WidgetControlUtils.hideView(nodata_tv);
            }
        } else {
            if (IKitchenApp.getInstance().getUser().getConcernsForUid().size() == 0) {
                WidgetControlUtils.hideView(listview);
                WidgetControlUtils.showView(nodata_tv);
                nodata_tv.setText("您还没有关注的人，点击右上角添加关注");
            } else {
                WidgetControlUtils.showView(listview);
                WidgetControlUtils.hideView(nodata_tv);
            }
        }
    }

    private void initActionbar() {
        headbar = (View) findViewById(R.id.head_bar);
        backll = (LinearLayout) findViewById(R.id.back_ll);
        title_textview = (TextView) findViewById(R.id.title_textview);
        img_menu = (ImageView) findViewById(R.id.img_menu);
        if (isFan) {
            title_textview.setText("我的粉丝");
        } else {
            title_textview.setText("我关注的");
        }
        WidgetControlUtils.showView(img_menu);
    }

    private void getData() {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", IKitchenApp.getInstance().getUser().getId());
        if (isFan) {
            map.put("operation", "fans");
        } else {
            map.put("operation", "concerns");
        }
        wtHttpUtils.doHttpRequest(ApplicationParams.http_url_get_fan_or_concern, WTHttpUtils.HTTP_POST, map, GetFriendsResult.class, new OnWTHttpRequestCompleteCallback() {
            @Override
            public void success(String s) {
            }

            @Override
            public void fail(String s) {
                MsgShowUtils.showToast(FriendsActivity.this, s);
            }

            @Override
            public void json(Map<String, Object> stringObjectMap) {

            }

            @Override
            public void json(Object o) {
                GetFriendsResult getFriendsResult = (GetFriendsResult) o;
                if (getFriendsResult.getStatus().equals("success")) {
                    userList = getFriendsResult.getUsers();
                    if (isFan) {
                        friendsAdapter = new FriendsAdapter(FriendsActivity.this, userList, 1, FriendsActivity.this);
                    } else {
                        friendsAdapter = new FriendsAdapter(FriendsActivity.this, userList, 2, FriendsActivity.this);
                    }
                    listview.setAdapter(friendsAdapter);
                } else {
                    MsgShowUtils.showToast(FriendsActivity.this, getFriendsResult.getErrorMsg());
                }


            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_ll:
                finish();
                break;
            case R.id.img_menu:
                Intent intent=new Intent(FriendsActivity.this,FindFriendActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void AddFollow(int position, int type) {
//        MsgShowUtils.showToast(FriendsActivity.this, "postion:" + position + "  type:" + type);
        if (type == 1) {
            int cid = -1;
            Concern tempCon;
            Iterator<Concern> iterator = userList.get(position).getConcernsForConcernuid().iterator();
            while (iterator.hasNext()) {
                tempCon = iterator.next();
                if (tempCon.getUid() == IKitchenApp.getInstance().getUser().getId()) {
                    cid = tempCon.getCid();
                }
            }
            if (cid != -1) {
                Ion.with(FriendsActivity.this).load(ApplicationParams.http_url_cancel_concern)
                        .setMultipartParameter("cid", String.valueOf(cid))
                        .as(new TypeToken<ConcernResult>() {
                        })
                        .withResponse()
                        .setCallback(new FutureCallback<Response<ConcernResult>>() {
                            @Override
                            public void onCompleted(Exception e, Response<ConcernResult> result) {
                                if (result.getResult().getStatus().equals("success")) {
                                    MsgShowUtils.showToast(FriendsActivity.this, result.getResult().getErrorMsg());
                                    UserUtils.relogin(FriendsActivity.this);
                                    getData();
                                } else {
                                    MsgShowUtils.showToast(FriendsActivity.this, result.getResult().getErrorMsg());
                                }
                            }
                        });
            }
        }else {
            Ion.with(FriendsActivity.this).load(ApplicationParams.http_url_add_concern)
                    .setMultipartParameter("uid",IKitchenApp.getInstance().getUser().getId().toString())
                    .setMultipartParameter("concernid",userList.get(position).getId().toString())
                    .as(new TypeToken<ConcernResult>(){})
                    .withResponse()
                    .setCallback(new FutureCallback<Response<ConcernResult>>() {
                        @Override
                        public void onCompleted(Exception e, Response<ConcernResult> result) {
                            if (result.getResult().getStatus().equals("success")) {
                                MsgShowUtils.showToast(FriendsActivity.this, result.getResult().getErrorMsg());
                                UserUtils.relogin(FriendsActivity.this);
                                getData();
                            } else {
                                MsgShowUtils.showToast(FriendsActivity.this, result.getResult().getErrorMsg());
                            }
                        }
                    });
        }
    }
}
