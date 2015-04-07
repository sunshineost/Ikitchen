package study.wp.ikitchen.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by wp on 2015-02-04.
 */
public class PreferenceUtils {
    public static String PREFERENCE_NAME="study.wp.ikitchen_preferences";
    public static boolean putString(Context context,String key,String value){
        SharedPreferences sharedPreferences=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(key,value);
        return editor.commit();
    }
    public static String getString(Context context,String key){
        return getString(context,key,null);
    }
    public static String getString(Context context,String key,String defaultValue){
        SharedPreferences sharedPreferences=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,defaultValue);
    }
    public static boolean putInt(Context context,String key,int value){
        SharedPreferences sharedPreferences=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(key,value);
        return editor.commit();
    }
    public static int getInt(Context context,String key,int defaultValue){
        SharedPreferences sharedPreferences=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key,defaultValue);
    }
    public static int getInt(Context context,String key){
        return getInt(context,key,-1);
    }

    public static boolean putLong(Context context, String key, long value) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong(key, value);
        return editor.commit();
    }
    public static long getLong(Context context, String key, long defaultValue) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getLong(key, defaultValue);
    }
    public static long getLong(Context context, String key) {
        return getLong(context, key, -1);
    }
    public static boolean putFloat(Context context, String key, float value) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat(key, value);
        return editor.commit();
    }
    public static float getFloat(Context context, String key, float defaultValue) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getFloat(key, defaultValue);
    }
    public static float getFloat(Context context, String key) {
        return getFloat(context, key, -1);
    }
    public static boolean putBoolean(Context context, String key, boolean value) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }
    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getBoolean(key, defaultValue);
    }
    public static boolean getBoolean(Context context, String key) {
        return getBoolean(context, key, false);
    }
}
