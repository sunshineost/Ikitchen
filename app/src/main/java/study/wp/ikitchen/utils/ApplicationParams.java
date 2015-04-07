package study.wp.ikitchen.utils;

/**
 * Created by wp on 2015-03-04.
 */
public class ApplicationParams {
    public static String host="http://121.40.62.155:80/IKitchen";

    /**
     * 获取基本常用信息
     */
    public static String http_url_get_common_properties=host+"/getcommenproperties.action";
    /**
     * 登陆以及注册
     */
    public static String http_url_login=host+"/login.action";
    public static String http_url_regitster=host+"/register.action";

    /**
     *关注，取消关注，获取关注
     */
    public static String http_url_get_fan_or_concern=host+"/getuserfansorconcern.action";
    public static String http_url_add_concern=host+"/addconcern.action";
    public static String http_url_cancel_concern=host+"/delconcern.action";

    /**
     * 查询用户
     */
    public static String http_url_find_user=host+"/finduserbyuidornickname.action";
    public static String http_url_get_user_by_uid=host+"/getuserbyuid.action";


}
