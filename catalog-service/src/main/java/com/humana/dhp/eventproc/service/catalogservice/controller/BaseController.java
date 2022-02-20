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
    public BaseResponse importFlow(@RequestBody CatalogRequest catalogRequest) {
        System.out.println("@RequestBody CatalogRequest: " + GsonUtil.convertObjToString(catalogRequest));
        BaseResponse baseResponse = flowService.importFlowDefinition(catalogRequest.getDataFlow());
        return baseResponse;
    }
//
    @PostMapping("/import-flow-version/flowId/{flowId}")
    public BaseResponse importFlowVersion(@RequestBody FlowVersionRequest flowVersionRequest,@PathVariable long flowId) {
        BaseResponse baseResponse = flowVersionService.importFlowVersion(flowId,flowVersionRequest.getFlowVersionModel());
        return baseResponse;
    }

    @GetMapping("/get-flow/page-number/{pageNumber}")
    public CatalogResponse getAllFlow(@PathVariable int pageNumber) {
        CatalogResponse catalogResponse = flowService.findAll(pageNumber);
        return catalogResponse;
    }

    @GetMapping("/get-flow/flowId/{flowId}")
    public BaseResponse getFlow(@PathVariable long flowId) {
        BaseResponse baseResponse = flowService.findOneByFlowId(flowId);
        return baseResponse;
    }

}
