package study.wp.ikitchen.application;

import android.app.Application;

import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

import study.wp.ikitchen.R;
import study.wp.ikitchen.model.PCookpeople;
import study.wp.ikitchen.model.PCooktime;
import study.wp.ikitchen.model.PCookway;
import study.wp.ikitchen.model.PHardlevel;
import study.wp.ikitchen.model.PTaste;
import study.wp.ikitchen.model.Tagdata;
import study.wp.ikitchen.model.Type;
import study.wp.ikitchen.model.User;

/**
 * Created by wp on 2015-03-04.
 */
public class IKitchenApp extends Application {

    //application 单例模式
    private static IKitchenApp instance;
    public static IKitchenApp getInstance(){
        if(instance==null){
            instance=new IKitchenApp();
        }
        return instance;
    }

    private User user;
    private Boolean isLogin=false;
    private List<Type> typeList=new ArrayList<>();
    private List<PCookpeople> pCookpeopleList=new ArrayList<>();
    private List<PCooktime> pCooktimeList=new ArrayList<>();
    private List<PCookway> pCookwayList=new ArrayList<>();
    private List<PHardlevel> pHardlevelList=new ArrayList<>();
    private List<PTaste> pTasteList=new ArrayList<>();
    private List<Tagdata> tagdataList=new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        //imageLoader设置
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .showImageForEmptyUri(R.drawable.img_nodata)
                .showImageOnFail(R.drawable.img_nodata2)
                .showImageOnLoading(R.drawable.img_loading)
                .build();
        ImageLoaderConfiguration config=new ImageLoaderConfiguration.Builder(getApplicationContext())
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2*1024*1024))
                .memoryCacheSize(2*1024*1024)
                .diskCacheSize(200*1023*1024)
                .diskCacheFileCount(200)
                .defaultDisplayImageOptions(options)
                .build();
        ImageLoader.getInstance().init(config);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Type> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }

    public List<PCookpeople> getpCookpeopleList() {
        return pCookpeopleList;
    }

    public void setpCookpeopleList(List<PCookpeople> pCookpeopleList) {
        this.pCookpeopleList = pCookpeopleList;
    }

    public List<PCooktime> getpCooktimeList() {
        return pCooktimeList;
    }

    public void setpCooktimeList(List<PCooktime> pCooktimeList) {
        this.pCooktimeList = pCooktimeList;
    }

    public List<PCookway> getpCookwayList() {
        return pCookwayList;
    }

    public void setpCookwayList(List<PCookway> pCookwayList) {
        this.pCookwayList = pCookwayList;
    }

    public List<PHardlevel> getpHardlevelList() {
        return pHardlevelList;
    }

    public void setpHardlevelList(List<PHardlevel> pHardlevelList) {
        this.pHardlevelList = pHardlevelList;
    }

    public List<PTaste> getpTasteList() {
        return pTasteList;
    }

    public void setpTasteList(List<PTaste> pTasteList) {
        this.pTasteList = pTasteList;
    }

    public List<Tagdata> getTagdataList() {
        return tagdataList;
    }

    public void setTagdataList(List<Tagdata> tagdataList) {
        this.tagdataList = tagdataList;
    }

    public Boolean getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Boolean isLogin) {
        this.isLogin = isLogin;
    }
}
