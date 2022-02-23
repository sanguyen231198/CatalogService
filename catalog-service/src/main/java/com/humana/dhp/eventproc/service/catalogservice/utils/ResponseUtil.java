package com.humana.dhp.eventproc.service.catalogservice.utils;

import com.humana.dhp.eventproc.service.catalogservice.model.CatalogResponse;

public class ResponseUtil {

    public static CatalogResponse getSuccess(String message) {
        CatalogResponse baseResponse = new CatalogResponse();
        baseResponse.setResponseCode("200");
        baseResponse.setMessage(message);
        return baseResponse;
    }

    public static CatalogResponse getFailed(String message) {
        CatalogResponse baseResponse = new CatalogResponse();
        baseResponse.setResponseCode("400");
        baseResponse.setMessage(message);
        return baseResponse;
    }
}
