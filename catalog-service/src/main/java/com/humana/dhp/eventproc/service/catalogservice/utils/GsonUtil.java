package com.humana.dhp.eventproc.service.catalogservice.utils;

import com.google.gson.Gson;

public class GsonUtil {
    private static final Gson GSON = new Gson();

    public static <T> T convert(Object o,Class<T> clazz){
        try {
            String json = GSON.toJson(o);
            return GSON.fromJson(json,clazz);
        }catch (Exception ex){
            return null;
        }
    }

    public static String convertObjToString(Object o){
        try {
            return GSON.toJson(o);
        }catch (Exception ex){
            return null;
        }
    }
}
