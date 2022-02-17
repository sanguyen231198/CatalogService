package com.humana.dhp.eventproc.service.catalogservice.utils;

import com.humana.dhp.eventproc.service.catalogservice.model.CatalogResponse;

public class ResponseUtil {
    public static CatalogResponse getSuccess(){
        CatalogResponse catalogResponse = new CatalogResponse();
        catalogResponse.setResponseCode("200");
        catalogResponse.setResponseDescription("Success");
        return catalogResponse;
    }
}
