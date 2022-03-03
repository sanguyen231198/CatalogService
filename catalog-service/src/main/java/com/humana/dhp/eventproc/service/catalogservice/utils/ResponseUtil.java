package com.humana.dhp.eventproc.service.catalogservice.utils;

import com.humana.dhp.eventproc.service.catalogservice.model.BaseResponse;

public class ResponseUtil {

    public static BaseResponse getSuccess(String message) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage(message);
        return baseResponse;
    }

    public static BaseResponse getFailed(String message) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage(message);
        return baseResponse;
    }
}
