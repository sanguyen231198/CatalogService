package com.humana.dhp.eventproc.service.catalogservice.controller;

import com.humana.dhp.eventproc.service.catalogservice.model.*;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowService;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowVersionService;
import com.humana.dhp.eventproc.service.catalogservice.utils.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("catalog/")
public class BaseController {
    @Autowired
    FlowService flowService;
    @Autowired
    FlowVersionService flowVersionService;

    @PostMapping("/import/flow")
    public CatalogResponse importFlow(@RequestBody CatalogRequest catalogRequest) {
        System.out.println("@RequestBody CatalogRequest: " + GsonUtil.convertObjToString(catalogRequest));
        CatalogResponse baseResponse = flowService.importFlowDefinition(catalogRequest.getDataFlow());
        return baseResponse;
    }
    //
    @PostMapping("/import/flow/{flowId}")
    public CatalogResponse importFlowVersion(@RequestBody FlowVersionRequest flowVersionRequest, @PathVariable long flowId) {
        CatalogResponse baseResponse = flowVersionService.importFlowVersion(flowId,flowVersionRequest.getFlowVersionModel());
        return baseResponse;
    }

    @GetMapping("/get-all-flow")
    public CatalogResponse getAllFlow(@RequestParam(name = "pageNumber", required = false)int pageNumber) {
        CatalogResponse catalogResponse = flowService.findAll(pageNumber);
        return catalogResponse;
    }

    @GetMapping("/get-flow/{flowId}")
    public CatalogResponse getFlow(@PathVariable long flowId) {
        CatalogResponse baseResponse = flowService.findOneByFlowId(flowId);
        return baseResponse;
    }

}
