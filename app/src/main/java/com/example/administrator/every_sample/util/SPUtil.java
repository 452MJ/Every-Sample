package com.example.administrator.every_sample.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2015/12/2.
 * 统一操作SharedPreferences
 */
public class SPUtil {

    private static Context context;
    private static SPUtil instance = null;

    /*************默认保存为String类型（int与boolean在末尾添加说明）**************/
    public static final String LOGIN = "login";//(boolean)登录标记
    public static final String TOKEN = "token";//登录标记
    public static final String USERID = "userId";//id
    public static final String SCHOOL_STAGE = "school_stage";//（int）学段：小学(12)、初中(13)、高中14
    public static final String SUBJECT = "subject";//（int）学科
    public static final String CHAPTER_INDEX = "chapter_index";//字典树
    public static final String CHAPTER = "chapter";//缓存章节JSON

    private SPUtil(){}

    private SPUtil(Context ctx){
        context = ctx;
    }

    public static SPUtil getInstance(Context ctx){
        if(instance == null){
            synchronized (SPUtil.class){
                if(instance == null){
                    instance = new SPUtil(ctx.getApplicationContext());
                }
            }
        }
        return instance;
    }

    private SharedPreferences getSP(){
        return context.getSharedPreferences("PrepareLesson", Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE | Context.MODE_APPEND | Context.MODE_MULTI_PROCESS);
    }

    /************字符串String(key-value)*************/
    public void setString(String key, String value){
        getSP().edit().putString(key, value).commit();
    }
    public String getString(String key){
        return getSP().getString(key, "");
    }

    /***************整型int(key-value)****************/
    public void setInt(String key, int value){
        getSP().edit().putInt(key, value).commit();
    }
    public int getInt(String key){
        return getSP().getInt(key, 0);
    }

    /**********布尔值boolean(key-value)****************/
    public void setBoolean(String key, boolean value){
        getSP().edit().putBoolean(key, value).commit();
    }
    public Boolean getBoolean(String key){
        return getSP().getBoolean(key, false);
    }


}
