package study.wp.ikitchen.fregment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import study.wp.ikitchen.R;
import study.wp.ikitchen.activity.CreateMenuActivity;
import study.wp.ikitchen.activity.FriendsActivity;
import study.wp.ikitchen.activity.LoginActivity;
import study.wp.ikitchen.activity.RegisterActivity;
import study.wp.ikitchen.application.IKitchenApp;
import study.wp.ikitchen.model.User;
import study.wp.ikitchen.utils.ApplicationParams;
import study.wp.ikitchen.utils.PreferenceUtils;
import study.wp.ikitchen.utils.WidgetControlUtils;

public class MemberFragment extends Fragment implements View.OnClickListener {
    final static int FRIEND_REQUEST=101;

    User user;
    ImageLoader imageLoader;
    ImageView headicon_img;
    LinearLayout concern_ll,collect_ll,menu_ll,commit_ll,work_ll,setting_ll,tologin_ll;
    TextView fan_tv,concern_tv,username_tv;
    Button login_bt,register_bt;


    public MemberFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageLoader=ImageLoader.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_member, container, false);
        headicon_img=(ImageView)rootView.findViewById(R.id.headicon_img);
        concern_ll=(LinearLayout)rootView.findViewById(R.id.concern_ll);
        collect_ll=(LinearLayout)rootView.findViewById(R.id.collect_ll);
        menu_ll=(LinearLayout)rootView.findViewById(R.id.menu_ll);
        commit_ll=(LinearLayout)rootView.findViewById(R.id.commit_ll);
        work_ll=(LinearLayout)rootView.findViewById(R.id.work_ll);
        setting_ll=(LinearLayout)rootView.findViewById(R.id.setting_ll);
        tologin_ll=(LinearLayout)rootView.findViewById(R.id.tologin_ll);
        fan_tv=(TextView)rootView.findViewById(R.id.fan_tv);
        concern_tv=(TextView)rootView.findViewById(R.id.concern_tv);
        username_tv=(TextView)rootView.findViewById(R.id.username_tv);
        login_bt=(Button)rootView.findViewById(R.id.login_bt);
        register_bt=(Button)rootView.findViewById(R.id.register_bt);
        login_bt.setOnClickListener(this);
        register_bt.setOnClickListener(this);
        headicon_img.setOnClickListener(this);
        collect_ll.setOnClickListener(this);
        menu_ll.setOnClickListener(this);
        commit_ll.setOnClickListener(this);
        work_ll.setOnClickListener(this);
        setting_ll.setOnClickListener(this);
        tologin_ll.setOnClickListener(this);
        fan_tv.setOnClickListener(this);
        concern_tv.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        refreshLoginStatu();

    }

    private void refreshLoginStatu() {
        user=IKitchenApp.getInstance().getUser();
        if(IKitchenApp.getInstance().getIsLogin()){
            WidgetControlUtils.showView(concern_ll);
            WidgetControlUtils.hideView(tologin_ll);
            username_tv.setText(user.getNickname());
            imageLoader.displayImage(ApplicationParams.host+user.getHeadicon(),headicon_img);
            fan_tv.setText("粉丝（"+user.getConcernsForConcernuid().size()+"）");
            concern_tv.setText("关注（"+user.getConcernsForUid().size()+"）");
        }else {
            WidgetControlUtils.hideView(concern_ll);
            WidgetControlUtils.showView(tologin_ll);
            username_tv.setText("未登录");
            imageLoader.displayImage("drawable://" + R.drawable.unlogin_avatar,headicon_img);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
    switch (v.getId()){
        case R.id.setting_ll:
            userlogoff();
            break;
        case R.id.login_bt:
            intent=new Intent(getActivity(),LoginActivity.class);
            getActivity().startActivity(intent);
            break;
        case R.id.register_bt:
            intent=new Intent(getActivity(), RegisterActivity.class);
            getActivity().startActivity(intent);
            break;
        case R.id.menu_ll:
            intent=new Intent(getActivity(), CreateMenuActivity.class);
            getActivity().startActivity(intent);
            break;
        case R.id.fan_tv:
            intent=new Intent(getActivity(), FriendsActivity.class);
            intent.putExtra("isFan",true);
            getActivity().startActivityForResult(intent,FRIEND_REQUEST);
            break;
        case R.id.concern_tv:
            intent=new Intent(getActivity(), FriendsActivity.class);
            intent.putExtra("isFan",false);
            getActivity().startActivityForResult(intent,FRIEND_REQUEST);
            break;

    }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==FRIEND_REQUEST){
            //更新用户关注信息数据
            fan_tv.setText("粉丝（"+user.getConcernsForConcernuid().size()+"）");
            concern_tv.setText("关注（"+user.getConcernsForUid().size()+"）");
        }
    }

    private void userlogoff() {
        IKitchenApp.getInstance().setUser(null);
        IKitchenApp.getInstance().setIsLogin(false);
        PreferenceUtils.putString(getActivity(), "mobile", null);
        PreferenceUtils.putString(getActivity(),"password",null);
        refreshLoginStatu();
    }

}
