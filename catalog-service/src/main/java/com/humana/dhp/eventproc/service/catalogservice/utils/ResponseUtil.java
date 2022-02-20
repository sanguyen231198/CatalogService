package com.humana.dhp.eventproc.service.catalogservice.utils;

import com.humana.dhp.eventproc.service.catalogservice.model.BaseResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.CatalogResponse;

public class ResponseUtil {

    public static BaseResponse getSuccess() {
        BaseResponse baseResponse = new CatalogResponse();
        baseResponse.setResponseCode("200");
        baseResponse.setResponseDescription("Success");
        return baseResponse;
    }

    public static BaseResponse getFailed(String message) {
        BaseResponse baseResponse = new CatalogResponse();
        baseResponse.setResponseCode("400");
        baseResponse.setResponseDescription(message);
        return baseResponse;
    }
}
