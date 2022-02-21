package com.humana.dhp.eventproc.service.catalogservice.controller;

import com.humana.dhp.eventproc.service.catalogservice.model.*;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowService;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowVersionService;
import com.humana.dhp.eventproc.service.catalogservice.utils.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BaseController {
    @Autowired
    FlowService flowService;
    @Autowired
    FlowVersionService flowVersionService;

    @PostMapping("/import-flow")
    public CatalogResponse importFlow(@RequestBody CatalogRequest catalogRequest) {
        System.out.println("@RequestBody CatalogRequest: " + GsonUtil.convertObjToString(catalogRequest));
        CatalogResponse baseResponse = flowService.importFlowDefinition(catalogRequest.getDataFlow());
        return baseResponse;
    }
    //
    @PostMapping("/import-flow-version/flowId/{flowId}")
    public CatalogResponse importFlowVersion(@RequestBody FlowVersionRequest flowVersionRequest, @PathVariable long flowId) {
        CatalogResponse baseResponse = flowVersionService.importFlowVersion(flowId,flowVersionRequest.getFlowVersionModel());
        return baseResponse;
    }

    @GetMapping("/get-flow/page-number/{pageNumber}")
    public CatalogResponse getAllFlow(@PathVariable int pageNumber) {
        CatalogResponse catalogResponse = flowService.findAll(pageNumber);
        return catalogResponse;
    }

    @GetMapping("/get-flow/flowId/{flowId}")
    public CatalogResponse getFlow(@PathVariable long flowId) {
        CatalogResponse baseResponse = flowService.findOneByFlowId(flowId);
        return baseResponse;
    }

}
