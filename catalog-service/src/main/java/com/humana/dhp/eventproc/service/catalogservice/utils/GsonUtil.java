package com.humana.dhp.eventproc.service.catalogservice.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.humana.dhp.eventproc.service.catalogservice.model.BaseRequest;
import com.humana.dhp.eventproc.service.catalogservice.model.BaseResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.CatalogResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowModel;

public class GsonUtil {
    private static final Gson GSON = new Gson();

    public static <T> T convert(Object o, Class<T> clazz) {
        try {
            String json = GSON.toJson(o);
            return GSON.fromJson(json, clazz);
        } catch (Exception ex) {
            return null;
        }
    }

    public static <T> T convert(Object o, TypeToken<T> type) {
        try {
            String json = GSON.toJson(o);
            return GSON.fromJson(json, type.getType());
        } catch (Exception ex) {
            return null;
        }
    }

    public static String convertObjToString(Object o) {
        try {
            return GSON.toJson(o);
        } catch (Exception ex) {
            return null;
        }
    }
}
