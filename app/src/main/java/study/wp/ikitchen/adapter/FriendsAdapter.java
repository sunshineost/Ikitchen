package study.wp.ikitchen.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import study.wp.ikitchen.R;
import study.wp.ikitchen.application.IKitchenApp;
import study.wp.ikitchen.model.Concern;
import study.wp.ikitchen.model.User;
import study.wp.ikitchen.model.response.ConcernResult;
import study.wp.ikitchen.utils.ApplicationParams;
import study.wp.ikitchen.utils.MsgShowUtils;

/**
 * Created by wp on 2015-03-26.
 */
public class FriendsAdapter extends BaseAdapter {
    List<User> userList = new ArrayList<>();
    Context context;
    ImageLoader imageLoader;
    //1粉丝，2我关注的
    int type = 1;
    AddFollow addFollow;
    GoToUserDynamic goToUserDynamic;

    public FriendsAdapter(Context context, List<User> userList, int type,AddFollow addFollow) {
        this.context = context;
        this.userList = userList;
        imageLoader = ImageLoader.getInstance();
        this.type = type;
        this.addFollow=addFollow;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public User getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        final int ctype;//1取消关注操作 2, 添加关注操作
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item_friends, null);
            viewHolder.add_friend_head = (ImageView) convertView.findViewById(R.id.add_friend_head);
            viewHolder.add_friend_btn = (ImageView) convertView.findViewById(R.id.add_friend_btn);
            viewHolder.add_friend_name = (TextView) convertView.findViewById(R.id.add_friend_name);
            viewHolder.add_follow = (TextView) convertView.findViewById(R.id.add_follow);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Log.e("imageLoader", ApplicationParams.host + userList.get(position).getHeadicon());
        imageLoader.displayImage(ApplicationParams.host + userList.get(position).getHeadicon(), viewHolder.add_friend_head);
        viewHolder.add_friend_name.setText(userList.get(position).getNickname());
        if (type == 1) {
            //判断我是否关注了他，如果关注了则显示加关注，如果没有关注就显示取消关注
            Iterator<Concern> iterator = userList.get(position).getConcernsForConcernuid().iterator();
            Concern tempCon;
            int flag = -1;
            while (iterator.hasNext()) {
                tempCon = iterator.next();
                if (tempCon.getUid() == IKitchenApp.getInstance().getUser().getId()) {
                    flag = 1;
                }
            }
            if (flag == 1) {
                //我也关注了我的粉丝
                viewHolder.add_follow.setText("取消关注");
                ctype = 1;
            } else {
                viewHolder.add_follow.setText("加关注");
                ctype = 2;
            }
        } else {
            viewHolder.add_follow.setText("取消关注");
            ctype = 1;
        }
        viewHolder.add_friend_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFollow.AddFollow(position,ctype);
            }
        });
        return convertView;
    }

    class ViewHolder {
        ImageView add_friend_head;
        TextView add_friend_name;
        ImageView add_friend_btn;
        TextView add_follow;
    }

    public interface AddFollow {
        public void AddFollow(int position, int type);
    }

    public interface GoToUserDynamic {
        public void GoToUserDynamic(int position);
    }

}
