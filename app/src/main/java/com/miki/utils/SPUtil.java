package com.miki.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author：su_lc on 2019/7/13 09:54
 */
public class SPUtil {

    public static String GUIDE_ISFIRST = "guide_isfirst";
    public static String getString(Context ctx, String key){
        SharedPreferences sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getString(key, "");
    }

    public static int getInt(Context ctx, String key){
        SharedPreferences sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getInt(key, 0);
    }
    //获取存储的是用户角标
    public static int getIntForUserDeafult(Context ctx, String key){
        SharedPreferences sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getInt(key, 1);
    }
    public static boolean getBoolean(Context ctx, String key){
        SharedPreferences sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    public static void put(Context ctx, String key , Object value){
        SharedPreferences sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        if(value instanceof String){
            edit.putString(key, (String) value);
        }else if( value instanceof Boolean){
            edit.putBoolean(key, (Boolean) value);
        }else if( value instanceof Integer){
            edit.putInt(key, (Integer) value);
        }
        edit.commit();
    }
    public static void clear(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }
    public static void clearignoreusername(Context context) {
        /*put(context, Constants.PASS_WORD, "");
        put(context, Constants.NICK, "");
        put(context, Constants.USER_IMG, "");
        put(context, Constants.SESSIONID, "");*/
    }
}
