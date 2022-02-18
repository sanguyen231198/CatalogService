package com.humana.dhp.eventproc.service.catalogservice.controller;

import com.humana.dhp.eventproc.service.catalogservice.entity.FlowEntity;
import com.humana.dhp.eventproc.service.catalogservice.model.CatalogRequest;
import com.humana.dhp.eventproc.service.catalogservice.model.CatalogResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowModel;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowVersionModel;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowService;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowVersionService;
import com.humana.dhp.eventproc.service.catalogservice.utils.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @Autowired
    FlowService flowService;
    @Autowired
    FlowVersionService flowVersionService;

    @PostMapping("/import-flow")
    public CatalogResponse importFlow(@RequestBody CatalogRequest catalogRequest) {
        System.out.println("@RequestBody CatalogRequest: " + GsonUtil.convertObjToString(catalogRequest));
        CatalogResponse catalogResponse = flowService.importFlowDefinition((FlowModel) catalogRequest.getDataFlow());
        return catalogResponse;
    }

    @PostMapping("/import-flow-version")
    public CatalogResponse importFlowVersion(@RequestBody CatalogRequest catalogRequest) {
        CatalogResponse catalogResponse = flowVersionService.importFlowVersion((FlowVersionModel)catalogRequest.getFlowVersionModel());
        return catalogResponse;
    }
}
