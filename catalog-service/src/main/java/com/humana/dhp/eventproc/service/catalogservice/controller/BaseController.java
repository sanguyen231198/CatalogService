package com.humana.dhp.eventproc.service.catalogservice.controller;

import com.humana.dhp.eventproc.service.catalogservice.entity.FlowEntity;
import com.humana.dhp.eventproc.service.catalogservice.model.CatalogRequest;
import com.humana.dhp.eventproc.service.catalogservice.model.CatalogResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowModel;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowService;
import com.humana.dhp.eventproc.service.catalogservice.utils.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @Autowired
    FlowService flowService;

    @PostMapping("/import-flow")
    public CatalogResponse importFlow(@RequestBody CatalogRequest catalogRequest) {
        System.out.println("@RequestBody CatalogRequest: " + GsonUtil.convertObjToString(catalogRequest));
        CatalogResponse catalogResponse = flowService.importFlowDefinition((FlowModel) catalogRequest.getDataFlow());
        return catalogResponse;
    }

    @PostMapping("/test")
    public String test(@RequestBody FlowEntity catalogRequest) {
        System.out.println("@RequestBody CatalogRequest: " + GsonUtil.convertObjToString(catalogRequest));
        return "tttt";
    }
}
